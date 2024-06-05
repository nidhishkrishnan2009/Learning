package java8;

import java.util.List;
import java.util.function.Consumer;

public class Java8Consumer {
    public static void main(String[] args) {
        List<Integer> list=List.of(8,7,6,4,3);
        Consumer<Integer> consumer=x-> System.out.println(x);
        print(list,consumer);
    }
    public static <T> void  print(List<T> list, Consumer<T> consumer){
        for(T data:list){
            consumer.accept(data);
        }
    }
}
