package com.learning.system_design.bridge;

public class Assembled implements Workshop{
    @Override
    public void work() {
        System.out.print(" And Assembled");
    }
}
