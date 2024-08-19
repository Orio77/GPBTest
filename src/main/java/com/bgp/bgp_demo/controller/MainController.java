package com.bgp.bgp_demo.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bgp.bgp_demo.model.Customer;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController {

    @GetMapping("/")
    public String welcomeUser() {
        return "Hello User!";
    }

    @GetMapping("/number/two")
    public int getTwo() {
        return 2;
    }

    @GetMapping("/number/random/ten")
    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    @GetMapping("/customer")
    public Customer getCustomerData(@RequestParam int id) {
        if (id == 1) {
            return new Customer("Customer 1", 123456789);
        } else
            return new Customer("Customer 2", 987654321);
    }

}
