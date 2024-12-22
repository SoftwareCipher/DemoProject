package com.demo.project;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        CompletableFuture.supplyAsync(
//                        () -> {
//                            try {
//                                Thread.sleep(1000);
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                            return "Result";
//                        }
//                ).thenApply(String::hashCode)
//                .thenCompose()
//                .exceptionally()
//                .handle()
//                .thenCombine()
//                .thenAccept()

//        try(ExecutorService executors = Executors.newFixedThreadPool(5)){
//            Future<Integer> f = executors.submit(() -> {
//                    Thread.sleep(10_000);
//                return 42;
//            });
//            Integer result = f.get(1000, TimeUnit.SECONDS);
//            System.out.println("Result: " + result);
//        }catch (InterruptedException e) {
//            log.error("Something else is wrong here", e);
//        }


        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = executor.submit(() -> {
                Thread.sleep(5000); // Задача занимает 5 секунд
                return 42;
            });

            log.info("Waiting for the result...");
            // Ожидаем завершения задачи с таймаутом 1 секунду
            Integer result = future.get(1, TimeUnit.SECONDS);
            log.info("Result: {}", result);

        } catch (Exception e) {
            log.error("Task did not complete within the timeout!", e);
        } finally {
            executor.shutdown();
        }
    }

}