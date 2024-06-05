package java8;

import java.util.*;
import java.util.function.Function;

public class Java8Function {

    public static void main(String[] args) {
        List<String> colorList= Arrays.asList(new String[]{"Red","yellow","green"});
        Java8Function obj=new Java8Function();
        Function<String,Integer> func=s->s.length();
        System.out.println("Convert map to list using function");
        System.out.println(convertMapToList(colorList,func));
        System.out.println("Convert map to list using method reference");
        System.out.println(convertMapToList(colorList,obj::getLength));
    }

    public static Map<String,Integer> convertMapToList(List<String> colorList, Function<String,Integer> func){
        Map<String,Integer> result=new HashMap<>();
        colorList.forEach(color->result.put(color,func.apply(color)));
        return  result;
    }

    public Integer getLength(String s){
        return s.length();
    }
}
