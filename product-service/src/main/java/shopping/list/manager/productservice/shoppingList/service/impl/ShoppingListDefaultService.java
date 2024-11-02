package shopping.list.manager.productservice.shoppingList.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.list.manager.productservice.shoppingList.entity.ShoppingList;
import shopping.list.manager.productservice.shoppingList.repository.api.ShoppingListRepository;
import shopping.list.manager.productservice.shoppingList.service.api.ShoppingListService;

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
    public Optional<ShoppingList> find(UUID id) {
        return shoppingListRepository.findById(id);
    }

    @Override
    public void create(ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
    }

    @Override
    public void delete(UUID id) {
        shoppingListRepository.findById(id).ifPresent(shoppingListRepository::delete);
    }
}
