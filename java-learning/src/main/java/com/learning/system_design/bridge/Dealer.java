package com.learning.system_design.bridge;

public class Dealer {
    public static void main(String[] args) {
        Vehicle car=new Car(new Produce(),new Assembled());
        Vehicle bike=new Bike(new Produce(),new Assembled());
        car.manufacture();
        System.out.println();
        bike.manufacture();
    }
}
