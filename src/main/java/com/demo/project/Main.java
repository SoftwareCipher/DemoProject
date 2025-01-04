package com.demo.project;

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
import java.util.concurrent.*;

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

        Logger.info("Hello World!");
    }
}
