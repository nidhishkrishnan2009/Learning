package com.learning.system_design.singleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testMultiThreadedSingletonNegativeTestCase();
        //testMultiThreadedSingletonPositiveTestCase();
    }

    private static void testEagerSingleton(){
        EagerSingleton eagerSingleton=EagerSingleton.getInstance();
        System.out.println(eagerSingleton.hashCode());
    }

    private static void breakSingletonUsingSynchronization(){
        try(FileOutputStream fos=new FileOutputStream("object.obj")){
            //fos.write(LazySingleton.getInstance());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void testMultiThreadedSingletonNegativeTestCase() throws ExecutionException, InterruptedException {
        CompletableFuture test1= CompletableFuture.runAsync(()->{
            LazySingleton lazySingleton=LazySingleton.getInstance();
            System.out.println(lazySingleton.hashCode());
        });

        CompletableFuture test2= CompletableFuture.runAsync(()->{
            LazySingleton lazySingleton=LazySingleton.getInstance();
            System.out.println(lazySingleton.hashCode());
        });
        Thread.sleep(5000);
        test1.get();
        test2.get();
    }

    private static void testMultiThreadedSingletonPositiveTestCase() throws ExecutionException, InterruptedException {
        CompletableFuture test1= CompletableFuture.runAsync(()->{
            MultiThreadedSingleton multiThreadedSingleton =MultiThreadedSingleton.getInstance();
            System.out.println(multiThreadedSingleton.hashCode());
        });

        CompletableFuture test2= CompletableFuture.runAsync(()->{
            MultiThreadedSingleton multiThreadedSingleton =MultiThreadedSingleton.getInstance();
            System.out.println(multiThreadedSingleton.hashCode());
        });
        Thread.sleep(5000);
        test1.get();
        test2.get();
    }
}
