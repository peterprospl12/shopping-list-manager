package org.example.shoppinglistmanager;

import org.example.shoppinglistmanager.dto.ProductDTO;
import org.example.shoppinglistmanager.entity.Product;
import org.example.shoppinglistmanager.entity.ShoppingList;
import org.example.shoppinglistmanager.entity.User;
import org.example.shoppinglistmanager.entity.enums.Category;
import org.example.shoppinglistmanager.entity.enums.Status;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ShoppingListManagerApplication {

    // Task 2
    public static void initialize(List<User> users) {
        System.out.println("Application started");
        User user1 = User.builder().firstName("Marek").lastName("Patka").age(30).build();
        User user2 = User.builder().firstName("Przemek").lastName("Lenovo").age(25).build();
        User user3 = User.builder().firstName("Rysiek").lastName("Dell").age(40).build();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println("Users added");

        ShoppingList shoppingList1 = ShoppingList.builder().name("List1224").date(LocalDate.ofYearDay(2024, 13)).status(Status.ACTIVE).user(user1).build();
        ShoppingList shoppingList2 = ShoppingList.builder().name("List255").date(LocalDate.ofYearDay(1995,15)).status(Status.ACTIVE).user(user2).build();
        ShoppingList shoppingList3 = ShoppingList.builder().name("List311").date(LocalDate.ofYearDay(2000, 25)).status(Status.ARCHIVED).user(user3).build();

        user1.addShoppingList(shoppingList1);
        user2.addShoppingList(shoppingList2);
        user3.addShoppingList(shoppingList3);

        System.out.println("Shopping lists added");

        Product product1 = Product.builder().name("Product1").category(Category.DRINKS).price(10).quantity(2).isBought(false).build();
        Product product2 = Product.builder().name("Product2").category(Category.FOOD).price(20).quantity(3).isBought(true).build();
        Product product3 = Product.builder().name("Product3").category(Category.HOUSEHOLD).price(30).quantity(4).isBought(false).build();
        Product product4 = Product.builder().name("Product4").category(Category.OTHER).price(40).quantity(5).isBought(true).build();
        Product product5 = Product.builder().name("Product5").category(Category.DRINKS).price(50).quantity(6).isBought(false).build();

        shoppingList1.addProduct(product1);
        shoppingList1.addProduct(product2);
        shoppingList2.addProduct(product3);
        shoppingList2.addProduct(product4);
        shoppingList3.addProduct(product5);

        System.out.println("Products added");

        System.out.println("Users: ");
        users.forEach(System.out::println);

        System.out.println();
    }

    // task 3
    public static void createSet(List<User> users, Set<ShoppingList> shopingLists) {
        users.stream().map(User::getShoppingLists).forEach(shopingLists::addAll);

        System.out.println("Shopping lists: ");
        shopingLists.forEach(System.out::println);

        System.out.println();
    }

    // task 4
    public static void filterAndSort(Set<ShoppingList> shoppingLists) {
        System.out.println("Active shopping lists sorted by date: ");
        shoppingLists.stream().filter(shoppingList -> shoppingList.getStatus().equals(Status.ACTIVE))
                .sorted(Comparator.comparing(ShoppingList::getDate))
                .forEach(System.out::println);

        System.out.println();
    }

    // task 5
    public static void convertIntoDTO(Set<ShoppingList> shoppingLists, List<ProductDTO> productDTOS) {
        System.out.println("Products converted into DTO: ");
        shoppingLists.stream().map(ShoppingList::getProducts)
                .flatMap(Collection::stream)
                .map(product -> ProductDTO.builder()
                        .name(product.getName())
                        .category(product.getCategory().name())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .isBought(product.isBought())
                        .build())
                .sorted()
                .forEach(productDTOS::add);

        productDTOS.forEach(System.out::println);
        System.out.println();
    }

    // task 6
    public static void serializeUsers(List<User> users) {
        System.out.println("Serializing users");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.dat"))) {
            users.forEach(user -> {
                try {
                    out.writeObject(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeUsers(List<User> users) {
        System.out.println("Deserializing users");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.dat"))) {
            while (true) {
                try {
                    users.add((User) in.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Deserialized users: ");
        users.forEach(System.out::println);
    }

    // task 7
    private static ForkJoinPool getForkJoinPool(List<User> users) {
        ForkJoinPool pool = new ForkJoinPool(3);
        Random random = new Random();
        pool.submit(() -> {
            users.parallelStream().forEach(user -> {
                System.out.println("User: " + user.getFirstName());
                user.getShoppingLists().forEach(shoppingList -> {
                    int sleepTime = random.nextInt(3) + 2;
                    try {
                        Thread.sleep(random.nextInt(sleepTime * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Shopping list: " + shoppingList.getName() + " sleep time: " + sleepTime);
                    shoppingList.getProducts().forEach(product -> {
                        try {
                            Thread.sleep(random.nextInt(sleepTime * 1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Product: " + product.getName() + " from list: " + shoppingList.getName() + " sleep time: " + sleepTime);
                    });
                });
            });
        });
        pool.shutdown();
        return pool;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListManagerApplication.class, args);
        List<User> users = new ArrayList<>();

        // task 2
        initialize(users);

        Set<ShoppingList> shoppingLists = new HashSet<>();
        // task 3
        createSet(users, shoppingLists);

        // task 4
        filterAndSort(shoppingLists);

        List<ProductDTO> productDTOS = new ArrayList<>();
        // task 5
        convertIntoDTO(shoppingLists, productDTOS);

        List<User> usersToSerialize = new ArrayList<>(users);
        // task 6
        serializeUsers(usersToSerialize);
        deserializeUsers(usersToSerialize);

        // task 7
        ForkJoinPool pool = getForkJoinPool(users);
        try {
            pool.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
