package java8;

import java.util.function.BiFunction;

public class Java8MethodReference {

    public static void main(String[] args) {
        System.out.println(concatString("Nidish","Krishnan",Java8MethodReference::concatObjects));
    }

    public static String concatString(String s1, String s2, BiFunction<String,String,String> func){
        return func.apply(s1,s2);
    }

    public static  <A1,A2,R1> R1 concatObjects(A1 obj1,A2 obj2){
        R1 result=null;
        if(obj1 instanceof String && obj2 instanceof String){
           result = (R1) String.format("%s %s",(String)obj1,(String)obj2);
        }
        return result;
    }
}
