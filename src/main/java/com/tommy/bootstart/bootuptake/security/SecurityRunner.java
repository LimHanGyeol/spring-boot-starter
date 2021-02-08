package com.tommy.bootstart.bootuptake.security;

import com.tommy.bootstart.bootuptake.security.domain.Customer;
import com.tommy.bootstart.bootuptake.security.service.CustomerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SecurityRunner implements ApplicationRunner {

    private final CustomerService customerService;

    public SecurityRunner(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer = customerService.create("hangyeol", "1234");
        System.out.println(customer.getUsername() + " password : " + customer.getPassword());
    }
}
