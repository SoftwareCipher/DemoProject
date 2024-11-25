package demo.project.service;

import demo.project.model.Dog;

public class Box<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public <U extends Number> void show(U u){
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());
    }

    public <U extends Number> double square(U u){
        return u.doubleValue() * u.doubleValue();
    }

    public <C extends Dog> String squareC(C c){
        return c.getName();
    }

}
