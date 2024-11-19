package shopping.list.manager.shoppinglistservice.shoppingList.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.shoppinglistservice.shoppingList.repository.api.ShoppingListRepository;
import shopping.list.manager.shoppinglistservice.shoppingList.service.api.ShoppingListEventPublisher;
import shopping.list.manager.shoppinglistservice.shoppingList.service.api.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoppingListDefaultService implements ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListEventPublisher shoppingListEventPublisher;
    private static final Logger logger = LoggerFactory.getLogger(ShoppingListDefaultService.class);


    @Autowired
    public ShoppingListDefaultService(ShoppingListRepository shoppingListRepository,
                                      ShoppingListEventPublisher shoppingListEventPublisher) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListEventPublisher = shoppingListEventPublisher;
    }

    @Override
    public Optional<ShoppingList> find(UUID id){
        return shoppingListRepository.findById(id);
    }

    @Override
    public Optional<List<ShoppingList>> findAllByUserId(UUID userId){
        return Optional.of(shoppingListRepository.findAllByUserId(userId));
    }

    @Override
    public List<ShoppingList> findAll(){
        return shoppingListRepository.findAll();
    }

    @Override
    public void create(ShoppingList shoppingList){
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void update(ShoppingList shoppingList){
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void delete(UUID id){
        if (!shoppingListRepository.existsById(id)) {
            logger.warn("Shopping list with id {} does not exist", id);
            return;
        }
        shoppingListRepository.deleteById(id);
        shoppingListEventPublisher.notifyShoppingListDeleted(id);
    }

    @Override
    public void deleteAllByUserId(UUID userId){
        shoppingListRepository.deleteAllByUserId(userId);
    }

}
