package java8;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Predicate {
    static Predicate<Integer> noLessThan5=x->x>5;

    public static void main(String[] args) {
        List<Integer> numberList=List.of(3,4,8,5,6,10);
        System.out.println(getElementsGreaterThan5(numberList,noLessThan5));
    }
    public static List<Integer> getElementsGreaterThan5(List<Integer> list,Predicate<Integer> noLessThan5){
        return list.stream().filter(noLessThan5).collect(Collectors.toList());
    }
}
