package com.learning.router;

import com.learning.handler.CustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ReactiveRouter {

    @Autowired
    private CustomerHandler handler;

    @Bean
    public RouterFunction<ServerResponse> routerConfig(){
       return RouterFunctions.route()
               .GET("/route/customer",handler::loadAllCustomers)
               .GET("/route/customer/stream",handler::loadAllCustomersUsingStream)
               .GET("/route/customer/{customerId}",handler::findCustomer)
               .POST("/route/customer/save",handler::saveCustomer)
               .build();
    }
}
