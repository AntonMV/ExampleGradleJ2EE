package ru.mikhaylov.model;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class Producer {
    @Produces
    String name = "Hello";

    @Produces
    @S2
    String name2 = "World";

    @Produces
    int age = 18;

    @Produces
    Car getCar(){
        return new Car("Lada");
    }

    public void clean(@Disposes Car car){
        car.clean();
    }
}
