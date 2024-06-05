package com.components;

import com.learning.model.Employer;
import com.learning.model.Person;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DependencyInjection.class)
public class ConditionalConfig {

    @Bean("custom")
    //@ConditionalOnBean(name = "customer")
    //@ConditionalOnResource(resources = "classpath:application.properties")
//    @ConditionalOnProperty(
//            name = "server.port",
//            havingValue = "2002"
//    )
 //   @ConditionalOnExpression("${server.port}")
    public Person getConditionalBean(){
        return new Employer("emp1",20);
    }
}
