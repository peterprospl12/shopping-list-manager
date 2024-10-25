package org.example.shoppinglistmanager.cmd;

import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.shoppinglistmanager.shoppingList.controller.api.ProductController;
import org.example.shoppinglistmanager.shoppingList.controller.api.ShoppingListController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            System.out.println("Enter command: ");
            command = scanner.nextLine();
            switch (command) {
                case "get_characters" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        System.out.println(writer.write(productController.getProducts()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "exit":
                    break main_loop;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
