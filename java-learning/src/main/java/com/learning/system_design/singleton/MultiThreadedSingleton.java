package com.learning.system_design.singleton;

public class MultiThreadedSingleton {
    private static MultiThreadedSingleton instance;
    private MultiThreadedSingleton(){

    }

    public static MultiThreadedSingleton getInstance(){
        if(instance==null)
        {
            synchronized (MultiThreadedSingleton.class){
                if(instance==null){
                    instance=new MultiThreadedSingleton();
                }
            }
        }
        return instance;
    }
}
