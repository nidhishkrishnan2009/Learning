package java8.reactive;

import io.reactivex.Observable;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Basic {


    public static void main(String[] args) {
//        Observable.range(1,5).subscribe(
//                number-> System.out.println(number),
//                error->error.printStackTrace(),
//                ()-> System.out.println("completed")
//
//        );
        AdderImpl adderImpl=new AdderImpl();
        String r = adderImpl.add(a -> a + " lambda");
        System.out.println(r);

        Predicate<Integer> y= x->{
            boolean isPrime=false;
            return isPrime;
        };
long fact=1;
        for(int i=1;i<=5;i++){
            fact*=i;

        }
        System.out.println(fact);
    }
}

 interface Adder {
    String add(Function<String, String> f);
    void add(Consumer<Integer> f);
}

 class AdderImpl implements Adder {

    @Override
    public  String add(Function<String, String> f) {
        return f.apply("Welcome ");
    }

    @Override
    public void add(Consumer<Integer> f) {}
}