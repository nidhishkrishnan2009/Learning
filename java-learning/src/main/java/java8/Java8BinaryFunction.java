package java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class Java8BinaryFunction {

    private static int result=0;
    public static void main(String[] args) {
        System.out.println(printResult(5,10,Java8BinaryFunction::sum));
        int[] list=new int[]{3,5,7,8};
        System.out.println(math(list,Java8BinaryFunction::sum));
        List<Developer> developerList=List.of(new Developer("abc",20,10000),new Developer("efg",21,5000),new Developer("xyz",22,15000));
        Comparator<Developer> compare=Comparator.comparing(Developer::getSalary);
        System.out.println(findDeveloperWith(BinaryOperator.maxBy(compare),developerList));
        System.out.println(findDeveloperWith(BinaryOperator.minBy(compare),developerList));
    }

    public static Developer findDeveloperWith(BinaryOperator<Developer> accumulator,List<Developer> developerList){
        Developer dev=null;

        for(Developer d:developerList){
            if(dev==null){
                dev=d;
            }
            else{
                dev=accumulator.apply(dev,d);
            }
        }
        return dev;
    }
    public static String printResult(int n1, int n2, BinaryOperator<Integer> accumulator){
      return "Result is "+accumulator.apply(n2,n2);
    }
    public static int sum(int n1,int n2){
       return n1+n2;
    }

    public static int math(int[] list,BinaryOperator<Integer>accumulator){

        IntStream.of(list).forEach(data->{
            result=accumulator.apply(result,data);
        });
        return result;
    }

    @AllArgsConstructor
    @Data
    static class Developer{
        private String name;
        private int age;
        private int salary;
    }
}
