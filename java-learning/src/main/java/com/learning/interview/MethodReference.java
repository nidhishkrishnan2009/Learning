package com.learning.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {
    public static void main(String[] args) {
        String input="HI, how are you?";
        List<String> list= Arrays.asList(input.split(" "));
        List<String> updatedList=new LinkedList<>();
        int index=0;
        for(String data:list){
            updatedList.add(index,data);
            index++;
            updatedList.add(index,"");
            index++;
        }
        updatedList.remove(updatedList.size()-1);
        List<String> convertedList=new LinkedList<>();
        updatedList.forEach(data->{
            if(data.isBlank()){
                convertedList.add("32");
            }
            else{
                int firstLetterAscii=data.charAt(0);
                String remainingString=data.substring(1);
                convertedList.add(firstLetterAscii+remainingString);
            }

        });

       List<String> convertedListUpdated =convertedList.stream()
                .map(data->{
                    if(data.equals("32")){
                        return new StringBuilder("#$").reverse().toString();
                    }
                    else{
                        return new StringBuilder(data).reverse().toString();
                    }
                })
                .collect(Collectors.toList());
        convertedListUpdated.forEach(System.out::println);
        String result=String.join("",convertedListUpdated);
        System.out.println(result);

    }
}
