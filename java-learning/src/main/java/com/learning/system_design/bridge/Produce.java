package com.learning.system_design.bridge;

public class Produce implements Workshop{
    @Override
    public void work() {
        System.out.print(" produced");
    }
}
