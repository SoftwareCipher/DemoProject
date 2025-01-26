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
import java.util.stream.IntStream;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {

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

//        System.out.println("Main thread is free to do other things...");

        CompletableFuture.supplyAsync(() -> {
                    return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 100))
                            .limit(5)
                            .toArray();
                })
                .thenApplyAsync(arr -> IntStream.of(arr).sum())
                .thenAccept(System.out::println)
                .join();

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


    }
}
