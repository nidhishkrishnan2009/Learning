package com.learning.handler;

import com.learning.dao.CustomerDao;
import com.learning.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao dao;

    public Mono<ServerResponse> loadAllCustomers(ServerRequest request){
        Flux<Customer> customerList = dao.loadAllCustomers();
        return ServerResponse.ok().body(customerList,Customer.class);
    }

    public Mono<ServerResponse> loadAllCustomersUsingStream(ServerRequest request){
        Flux<Customer> allCustomersStream = dao.findAllCustomersStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(allCustomersStream,Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest request){
        int customerId = Integer.valueOf(request.pathVariable("customerId"));
        //dao.loadAllCustomers().filter(data->data.getId()==customerId).take(1).single()
        Mono<Customer> customer = dao.loadAllCustomers().filter(data -> data.getId() == customerId).next();
        return ServerResponse.ok().body(customer,Customer.class);
    }

    public Mono<ServerResponse> saveCustomer(ServerRequest request){
        Mono<Customer> customerMono = request.bodyToMono(Customer.class);
        Mono<String> response = customerMono.map(data -> String.format("%s - %d", data.getName(), data.getId()));
        return ServerResponse.ok().body(response,String.class);
    }
}
