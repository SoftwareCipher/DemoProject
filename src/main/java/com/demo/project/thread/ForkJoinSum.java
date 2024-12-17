package com.demo.project.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSum extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 1000;

    public ForkJoinSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for(int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;
            ForkJoinSum leftTask = new ForkJoinSum(numbers, start, mid);
            ForkJoinSum rightTask = new ForkJoinSum(numbers, mid, end);
            leftTask.fork(); // Асинхронно запускаем левую задачу
            long rightResult = rightTask.compute(); // Синхронно запускаем правую задачу
            long leftResult = leftTask.join(); // Ждем завершения левой задачи
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        long[] numbers = new long[100_000_000];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSum task = new ForkJoinSum(numbers, 0, numbers.length);

        long startTime = System.currentTimeMillis();
        long parallelSum = pool.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel sum: " + parallelSum);
        System.out.println("Parallel time: " + (endTime - startTime) + " ms");
    }

    private static long calculateSumSingleThread(long[] array) {
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum;
    }
}
