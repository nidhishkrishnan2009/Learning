package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Java8UnaryOperator {

    public static void main(String[] args) {
        int[] data=new int[] {2,3,4,5,7};
        UnaryOperator<Integer> uo1=x->x*2;
        UnaryOperator<Integer> uo2=x->x+1;
        System.out.println(multiplyAndAdd(uo1,uo2,data));
    }

    public static List<Integer> multiplyAndAdd(UnaryOperator<Integer> uo1,UnaryOperator<Integer>uo2,int[] data){
        List<Integer> result=new ArrayList<>();
        IntStream.of(data).forEach(element->{
            result.add(uo1.andThen(uo2).apply(element));
        });
        return result;
    }
}
