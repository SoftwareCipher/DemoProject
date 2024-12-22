package com.demo.project;

import com.demo.project.Stream.Human;
import demo.project.model.Animal;
import lombok.SneakyThrows;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        int age = 10;
//        arr.add(age);
//
//        Integer[] arr1 = new Integer[3];
//        String a = "Kirill";
//        String a1 = new String("Kirill");
//        a1.intern();
//
//        Animal[] animals = new Animal[3];
//        animals[0] = new Dog();
//        method(animals);
//
//        List<Animal> animals1 = new ArrayList<>();
//        animals1.add(new Dog());
//
//        method2(animals1);
//
//        Dog[] dogs = new Dog[3];
//        method(dogs);
//
//        List<Dog> dogs1 = new ArrayList<>();
//        dogs1.add(new Dog());
//
//        method2(dogs1);

//        Dog name = new Dog("John");
//        Dog name2 = new Dog("John");
//        Set<Dog> dogsSet = new HashSet<>();
//        dogsSet.add(name);
//        dogsSet.add(name2);
//
//        System.out.println(dogsSet);

//
//        OrderRepository repository = new InMemoryOrderRepository();
//        ServiceOrder serviceOrder = new ServiceOrder(repository);
//
//        Order order = serviceOrder.findOrderById(1);
//        System.out.println(order != null ? "Order found!" : "Order not found.");

//    Animal[] animals = new Animal[3];
//    animals[1] = new Dog();
//    method(animals);
//
//    List<Animal> animalList = new ArrayList<>();
//    animalList.add(new Dog());
//    method2(animalList);
//
//    Dog[] dogs = new Dog[3];
//    dogs[1] = new Dog();
//    method(dogs);
//
//    List<Dog> dogList = new ArrayList<>();
//    dogList.add(new Dog());
//    method2(dogList);
//
//    method2(animalList);

//        Box<Integer> box = new Box<>();
//        box.setT(Integer.valueOf(10));
//        box.show(Double.valueOf(5));

//
//        MyList<Integer> myList = new MyList<>();
//        myList.add(15);
//        myList.add(20);
//        myList.add(30);
//        System.out.println(myList.get(2));

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("A");
//        arrayList.add("B");
//
//        arrayList.add(2, "C");
//        System.out.println(arrayList);
//        List<Integer> integers = new ArrayList<>();
//        boolean t = integers.contains(1);

//        List<List<String>> list = Arrays.asList(
//                Arrays.asList("a"),
//                Arrays.asList("b"));
//        System.out.println(list);
//
//        System.out.println(list
//                .stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList()));

//        List<Human> humans = asList(
//                new Human("Sam", asList("Buddy", "Lucy")),
//                new Human("Bob", asList("Frankie", "Rosie")),
//                new Human("Marta", asList("Simba", "Tilly")));
//
//        System.out.println(humans);
//
//        List<String> petNames = humans.stream()
//                .map(Human::pets)
//                .flatMap(Collection::stream)
//                .toList();
//
//        System.out.println(petNames);

//        new Thread(() -> System.out.println("Hello from: " + Thread.currentThread().getName())).start();

//        String txt = "geeksforgeeks";
//        String pat = "eks";
//
//        System.out.println(IntStream.iterate(txt.indexOf(pat),
//                        i -> i != -1,
//                        i -> txt.indexOf(pat, i + 1))
//                .count());
//
//        List<String> strings = new LinkedList<>();
//        strings.add("Heello");
//        strings.add("Heello1");
//        strings.add("Heello2");
//        strings.add("Heello3");
//        strings.add("Heello4");
//
//        System.out.println();

//        int[] array = new int[1000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i + 1;
//        }
//
//        long sum = Arrays.stream(array).parallel().sum();
//        System.out.println("Sum: " + sum);
//
//
//        ArrayDeque<String> myArrayDeque1 = new ArrayDeque<>();
//        myArrayDeque1.addLast("Hello_1");
//        myArrayDeque1.addLast("Hello_2");
//        myArrayDeque1.addLast("Hello_3");
//        myArrayDeque1.addLast("Hello_4");
//        myArrayDeque1.addLast("Hello_5");
//        myArrayDeque1.addLast("Hello_6");
//        myArrayDeque1.addLast("Hello_7");
//        myArrayDeque1.addLast("Hello_8");
//        myArrayDeque1.addLast("Hello_9");
//        myArrayDeque1.addLast("Hello_10");
//        myArrayDeque1.addFirst("Hello_11");
//        System.out.println(myArrayDeque1.toString());









        Student s1 = new Student(211, "ravi");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("demo.txt"));
        out.writeObject(s1);
        out.flush();
        out.close();
        System.out.println("success");


        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("demo.txt"))) {
            Student s = (Student) in.readObject();
            System.out.println(s.id + " " + s.name);
        } catch (Exception e) {
            System.out.println(e);
        }


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
//
//            Runnable task = () -> {
//                System.out.println("Hello from virtual thread: " + Thread.currentThread());
//            };
//
//            // Создание и запуск виртуальных потоков
//            for(int i = 0; i < 100; i++) {
//                Thread.startVirtualThread(task);
//            }
//
////             Альтернативный способ с использованием ExecutorService
//            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//                for(int i = 0; i < 100; i++) {
//                    executor.submit(task);
//                }
//            }

    }

    public static void method(Animal[] animals) {

    }

    public static void method2(List<? extends Animal> animals) {
        // animals.add(new Dog()); // only read !!!
    }
}