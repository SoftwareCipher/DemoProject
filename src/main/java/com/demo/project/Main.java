package com.demo.project;

import com.demo.project.model.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.tinylog.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//
//        CompletableFuture.supplyAsync(() -> {
//                    System.out.println("Task running in: " + Thread.currentThread().getName());
//                    return 42;
//                }).thenApply(result -> {
//                    System.out.println("Transforming result: " + result);
//                    return result * 2;
//                }).thenApply(result -> {
//                    System.out.println("Transforming result: " + result);
//                    return result * 2;
//                }).thenCompose(r -> CompletableFuture.supplyAsync(
//                        () -> r * 22))
//                .handle((r, ex) -> {
//                    if(ex != null){
//                        ex.getMessage();
//                    }
//                    return r;
//                }).thenAccept(result -> {
//                    System.out.println("Final result: " + result);
//                });
//
//        log.info("Приложение запущено!");
//        log.debug("Это отладочное сообщение.");
//        log.error("Ошибка: что-то пошло не так.");
//
//        System.out.println("Main thread is free to do other things...");

//
//
//        Path path = Paths.get("example.txt");
//        try {
//            Files.createFile(path);
//            System.out.println("Файл создан: " + path);
//        } catch (FileAlreadyExistsException e) {
//            System.out.println("Файл уже существует.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//
//        ArrayList<Person> people = new ArrayList<>();
//        people.add(new Person("Alice", 30));
//        people.add(new Person("Bob", 25));
//        people.add(new Person("Charlie", 35));
//
//
//        Collections.sort(people, new SortByNameComparator());
//
//        //Сортировка с использованием естественного порядка
//        Collections.sort(people);
//
//        System.out.println("Sorted by age:");
//        for (Person person : people) {
//            System.out.println(person);
//        }


//        String[] data = {"apple", "banana", "cherry"};
//        MyCollection<String> collection = new MyCollection<>(data);
//
//        for (String item : collection) {
//            System.out.println(item);
//        }
//
//        //Создаем итератор отдельно
//        MyIterator<String> iterator = new MyIterator<>(collection);
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        List<Product> products = List.of(
                new Product("Phone", 800, "Electronics"),
                new Product("Laptop", 1200, "Electronics"),
                new Product("Book", 30, "Books"),
                new Product("Pen", 5, "Stationery"),
                new Product("Tablet", 300, "Electronics")
        );
        List<String> topProducts= products.stream()
                .filter(product -> product.getPrice() > 100)
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .map(product -> product.getName().toUpperCase())
                .limit(3)
                .toList();
        System.out.println(topProducts);


        String text = "Java is awesome and Stream API is powerful. Java and API are great.";
        Map<String, Long> wordCount =
                Arrays.stream(text.split("\\W+"))
                        .map(String::toLowerCase)
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(wordCount);
    }
}
