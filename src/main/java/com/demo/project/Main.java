package com.demo.project;

import com.demo.project.Stream.Human;
import demo.project.model.Animal;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
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

        List<Human> humans = asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        System.out.println(humans);

        List<String> petNames = humans.stream()
                .map(Human::pets)
                .flatMap(Collection::stream)
                .toList();

        System.out.println(petNames);
    }

    public static void method(Animal[] animals) {

    }

    public static void method2(List<? extends Animal> animals) {
        // animals.add(new Dog()); // only read !!!
    }
}