package org.example.shoppinglistmanager.cmd;

import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.shoppinglistmanager.shoppingList.controller.api.ProductController;
import org.example.shoppinglistmanager.shoppingList.controller.api.ShoppingListController;
import org.example.shoppinglistmanager.shoppingList.dto.product.PutProductRequest;
import org.example.shoppinglistmanager.shoppingList.dto.shoppingList.PutShoppingListRequest;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Category;
import org.example.shoppinglistmanager.shoppingList.entity.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final ProductController productController;
    private final ShoppingListController shoppingListController;
    private final ObjectWriter writer;

    @Autowired
    public ApplicationCommand(ProductController productController, ShoppingListController shoppingListController, ObjectWriter writer) {
        this.productController = productController;
        this.shoppingListController = shoppingListController;
        this.writer = writer;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            System.out.println("Enter command: ");
            command = scanner.nextLine();
            switch (command) {
                case "get_products" -> {
                    try {
                        System.out.println(writer.writeValueAsString(productController.getProducts()));
                    } catch (NoSuchElementException ex){
                        System.out.println("Shopping list not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "get_shopping_lists" -> {
                    try {
                        System.out.println(writer.writeValueAsString(shoppingListController.getShoppingLists()));
                    } catch (NoSuchElementException ex){
                        System.out.println("Shopping list not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "get_user_shopping_lists" -> {
                    System.out.println("Enter user id: ");
                    UUID userId = UUID.fromString(scanner.nextLine());
                    try {
                        System.out.println(writer.writeValueAsString(shoppingListController.getUserShoppingLists(userId)));
                    } catch (NoSuchElementException ex){
                        System.out.println("Shopping list not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "get_shopping_list" -> {
                    System.out.println("Enter shopping list id: ");
                    UUID shoppingListId = UUID.fromString(scanner.nextLine());
                    try {
                        System.out.println(writer.writeValueAsString(shoppingListController.getShoppingList(shoppingListId)));
                    } catch (NoSuchElementException ex){
                        System.out.println("Shopping list not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "delete_product" -> {
                    System.out.println("Enter product id: ");
                    UUID productId = UUID.fromString(scanner.nextLine());
                    try {
                        productController.deleteProduct(productId);
                    } catch (NoSuchElementException ex){
                        System.out.println("Shopping list not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "delete_shopping_list" -> {
                    System.out.println("Enter shopping list id: ");
                    UUID shoppingListId = UUID.fromString(scanner.nextLine());
                    try {
                        shoppingListController.deleteShoppingList(shoppingListId);
                    } catch (NoSuchElementException ex){
                        System.out.println("Shopping list not found");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "put_shopping_list" -> {
                    System.out.println("Enter shopping list name: ");
                    String shoppingListName = scanner.nextLine();
                    System.out.println("Enter shopping list userId: ");
                    UUID shoppingListUserId = UUID.fromString(scanner.nextLine());
                    System.out.println("Enter shopping list status: ");
                    String shoppingListStatus = scanner.nextLine();
                    try {
                        shoppingListController.putShoppingList(UUID.randomUUID(),PutShoppingListRequest.builder()
                                .name(shoppingListName)
                                .date(LocalDate.now())
                                .status(Status.valueOf(shoppingListStatus.toUpperCase()))
                                .user(shoppingListUserId)
                                .build());
                        System.out.println("Shopping list created");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid request");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "put_product" -> {
                    System.out.println("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product category: ");
                    String productCategory = scanner.nextLine();
                    System.out.println("Enter product price: ");
                    double productPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter product quantity: ");
                    int productQuantity = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter product isBought: ");
                    boolean productIsBought = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("Enter product shopping list id: ");
                    UUID shoppingListId = UUID.fromString(scanner.nextLine());
                    try {
                        productController.putProduct(UUID.randomUUID(), PutProductRequest.builder()
                                        .name(productName)
                                        .category(Category.valueOf(productCategory.toUpperCase()))
                                        .price(productPrice)
                                        .quantity(productQuantity)
                                        .isBought(productIsBought)
                                        .shoppingList(shoppingListId)
                                .build());
                        System.out.println("Product created");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid request");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "exit" -> {
                    break main_loop;
                }
                default -> {
                    System.out.println("Unknown command");
                }
            }
        }
    }
}
