package com.learning.controller;

import com.learning.model.drools.Order;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BRMSController {

//    @Autowired
//    private KieSession kieSession;

    @Autowired
    private KieContainer kieContainer;

    @PostMapping("/drools/order")
    @Transactional
    public Order orderNow(@RequestBody Order order){
        KieSession kieSession=kieContainer.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();
        return order;
    }
}
