package com.bootcoding.java.service;

import com.bootcoding.java.model.Order;

import static com.bootcoding.java.model.OrderStatus.NEW;

public class OrderService {
    public boolean createOrder(){
        Order order   = new Order();
        order.setId(1);
        order.setCustomerId(1);
        order.setStatus(NEW);
        order.setTotalPrice(500.00);
        order.setDeliveryAddress("Bootcoding, HasanBag");
        order.setVendorId(1);
        order.print();
        System.out.println("Your Order Has Been Placed Successfully!!!");
        double price = applyDiscount(order.getTotalPrice());
        System.out.println("Total price after applying discount is "+ price);

        return true;
    }
    public double applyDiscount(double TotalPrice){
        double discount= TotalPrice * 0.1;
        double finalAmount = TotalPrice-discount;
        return finalAmount;

    }

}
