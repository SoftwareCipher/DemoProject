package com.demo.project;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task running in: " + Thread.currentThread().getName());
                    return 42;
                }).thenApply(result -> {
                    System.out.println("Transforming result: " + result);
                    return result * 2;
                }).thenApply(result -> {
                    System.out.println("Transforming result: " + result);
                    return result * 2;
                }).thenCompose(r -> CompletableFuture.supplyAsync(
                        () -> r * 22))
                .handle((r, ex) -> {
                    if(ex != null){
                        ex.getMessage();
                    }
                    return r;
                }).thenAccept(result -> {
                    System.out.println("Final result: " + result);
                });

        log.info("Приложение запущено!");
        log.debug("Это отладочное сообщение.");
        log.error("Ошибка: что-то пошло не так.");

        System.out.println("Main thread is free to do other things...");
    }
}
