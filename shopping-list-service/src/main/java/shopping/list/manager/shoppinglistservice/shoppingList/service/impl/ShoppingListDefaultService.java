package shopping.list.manager.shoppinglistservice.shoppingList.service.impl;

import shopping.list.manager.shoppinglistservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.shoppinglistservice.shoppingList.repository.api.ShoppingListRepository;
import shopping.list.manager.shoppinglistservice.shoppingList.service.api.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShoppingListDefaultService implements ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListDefaultService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public Optional<ShoppingList> find(UUID id){
        return shoppingListRepository.findById(id);
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
        shoppingListRepository.deleteById(id);
    }

}
