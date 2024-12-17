package com.demo.project.thread;

public class SingleThreadSumMain {
    public static void main(String[] args) {
        long[] numbers = new long[100_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        long startTime = System.currentTimeMillis();
        long singleThreadSum = calculateSumSingleThread(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("Single-threaded sum: " + singleThreadSum);
        System.out.println("Single-threaded time: " + (endTime - startTime) + " ms");
    }

    private static long calculateSumSingleThread(long[] array) {
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum;
    }
}
