package com.learning.interview;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class StoreElementsInCollection
{

    public static void main(String[] args) {
        String input = "cheese sandwich,mix veg sandwich,corn sandwich,Test";
        List<String> sandwichList=new ArrayList<>();
        List<String> staticSandwiches=new ArrayList<>();
        staticSandwiches.add("cheese sandwich");
        staticSandwiches.add("mix veg sandwich");
        staticSandwiches.add("corn sandwich");
        Consumer<String> addSandwich=sandwich ->{
            sandwichList.addAll(Arrays.asList(sandwich.split(",")));

        };
        addSandwich.accept(input);

        Supplier<List<String>> printSandwich=()->{
           boolean inValidSandwich= sandwichList.stream().anyMatch(sandwich->!staticSandwiches.contains(sandwich));
           if(inValidSandwich){
               System.out.println("Inorrect Input");
           }
           else{
               sandwichList.forEach(System.out::println);
           }
            return sandwichList;
        };

        printSandwich.get();

        IntToLongFunction f1=x->Long.valueOf(x);

        Integer i=10;
        System.out.println(f1.applyAsLong(10));

    }

    class FuncTest{
       private Function<String,String> func1;
       public FuncTest(Function<String,String> func1){

       }
    }
}