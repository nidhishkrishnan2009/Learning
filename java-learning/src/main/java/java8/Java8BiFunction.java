package java8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction {
    public static void main(String[] args) {
        Integer concatenatedString=concatAndFindLength((input1, input2)->String.format("%s %s",input1,input2),"Nidish","Krishnan",Java8BiFunction::getLength);
        System.out.println(concatenatedString);
        BiFunction<Integer, Integer, Double> division = Java8BiFunction::division;
        System.out.println(division.apply(6,2));
    }



    public static <A1,A2,R,K> K concatAndFindLength(BiFunction<A1,A2,R> func, A1 input1, A2 input2, Function<R,K> func2){
        return func.andThen(func2).apply(input1,input2);
    }

    public static  double division(int n1,int n2){
        return n1/n2;
    }

    public static Integer getLength(String s){
        return s.length();
    }
}
