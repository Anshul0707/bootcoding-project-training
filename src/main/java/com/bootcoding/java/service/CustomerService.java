package com.bootcoding.java.service;

import com.bootcoding.java.model.Customer;

import java.util.Date;

public class CustomerService {

    public void registerCustomer(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setCity("nagpur");
        customer.setName("Khushboo");
        customer.setDeliveryAddress("Bootcoding ,Nagpur");
        customer.setEmailId("kjain3437@gmail.com");
        customer.setCreatedAt(new Date());
        customer.setModifiedAt(new Date());
        customer.setState("Maharashtra");
        customer.setPassword("8605824718");
        customer.print();
        System.out.println("Customer has been registered successfully");
    }
}
