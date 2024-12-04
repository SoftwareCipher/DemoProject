package com.demo.project;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwitterMessageProcessor {
    public List<String> proccess(List<String> list){
        return list.stream()
                .flatMap(word -> Arrays.stream(word.split("\\s+")))
                .filter(l -> l.startsWith("#"))
                .map(word -> word.replaceAll("#", ""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }
}
