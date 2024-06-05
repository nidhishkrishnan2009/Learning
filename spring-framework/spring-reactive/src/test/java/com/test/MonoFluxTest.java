package com.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void monoTest(){
        Mono<?> monoString=Mono.just("Mono Test")
                .then(Mono.error(new RuntimeException("exception occurred")))
                .log();
        //monoString.subscribe(System.out::println);
        monoString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));
    }

    @Test
    public void fluxTest(){
        Flux<?> fluxString=Flux.just("Apple","Orange","Grapes")
                .concatWithValues("Pineapple")
                .concatWith(Flux.error(new RuntimeException("exception occurred")))
                .concatWithValues("Mango")
                .log();
        fluxString.subscribe(System.out::println,(e)->e.getMessage());
    }

}
