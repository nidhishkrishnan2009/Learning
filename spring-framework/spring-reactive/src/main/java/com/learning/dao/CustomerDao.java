package com.learning.dao;

import com.learning.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@Slf4j
public class CustomerDao {

    private static void sleep(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Customer> findAllCustomers(){
       return IntStream.rangeClosed(1,10)
                .peek(c->sleep(1000))
                .peek(i-> log.debug("processing customer {}",i))
                .mapToObj(i->new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> findAllCustomersStream(){
        return Flux.range(1,10)
                .delayElements(Duration.ofMillis(1000))
                .doOnNext(i->log.debug("processing customer {} using stream",i))
                .map(i->new Customer(i,"customer"+i));
    }

    public Flux<Customer> loadAllCustomers(){
        return Flux.range(1,50)
                .doOnNext(i->log.debug("processing customer {} using stream",i))
                .map(i->new Customer(i,"customer"+i));
    }

}
