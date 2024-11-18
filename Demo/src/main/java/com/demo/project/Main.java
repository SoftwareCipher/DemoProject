package demo.project;

import demo.project.model.Order;
import demo.project.repo.OrderRepository;
import demo.project.service.InMemoryOrderRepository;
import demo.project.service.ServiceOrder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    Animal[] animals = new Animal[3];
    animals[1] = new Dog();
    method(animals);

    List<Animal> animalList = new ArrayList<>();
    animalList.add(new Dog());
    method2(animalList);

    Dog[] dogs = new Dog[3];
    dogs[1] = new Dog();
    method(dogs);

    List<Dog> dogList = new ArrayList<>();
    dogList.add(new Dog());
    method2(dogList);

    }

    public static void method(Animal[] animals){

    }

    public static void method2(List<? extends Animal> animals){
    }
}