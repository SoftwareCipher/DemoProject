package com.demo.project;

import java.util.Arrays;

public class ParallelStreamSumMain {
    public static void main(String[] args) {
        long[] numbers = new long[100_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        long startTime = System.currentTimeMillis();
        long sum = Arrays.stream(numbers).parallel().sum();
        long endTime = System.currentTimeMillis();

        System.out.println("Parallel stream sum: " + sum);
        System.out.println("Parallel stream time: " + (endTime - startTime) + " ms");
    }
}
