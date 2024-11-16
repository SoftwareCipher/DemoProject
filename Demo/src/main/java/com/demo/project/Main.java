package demo.project;

import demo.project.model.Order;
import demo.project.repo.OrderRepository;
import demo.project.service.InMemoryOrderRepository;
import demo.project.service.ServiceOrder;

import java.util.ArrayList;
import java.util.List;

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

        Animal[] animals = new Animal[3];
        animals[0] = new Dog();
        method(animals);

        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Dog());

        method2(animals1);

        Dog[] dogs = new Dog[3];
        method(dogs);

        List<Dog> dogs1 = new ArrayList<>();
        dogs1.add(new Dog());

//        method2(dogs1);

//        demo.Dog name = new demo.Dog("John");
//        demo.Dog name2 = new demo.Dog("John");
//        Set<demo.Dog> dogsSet = new HashSet<>();
//        dogsSet.add(name);
//        dogsSet.add(name2);
//
//        System.out.println(dogsSet);


        OrderRepository repository = new InMemoryOrderRepository();
        ServiceOrder serviceOrder = new ServiceOrder(repository);

        Order order = serviceOrder.findOrderById(1);
        System.out.println(order != null ? "Order found!" : "Order not found.");

    }

    public static void method(Animal[] animals){

    }

    public static void method2(List<Animal> animals){

    }
}