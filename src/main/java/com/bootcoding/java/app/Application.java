package com.bootcoding.java.app;

import com.bootcoding.java.dao.DAOService;
import com.bootcoding.java.dao.CustomerDAO;
import com.bootcoding.java.dao.OrderDAO;
import com.bootcoding.java.model.Order;
import com.bootcoding.java.model.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        DAOService dbService = new DAOService();
//        dbService.printCustomerData();
//        System.out.println("********************************************************");
//        dbService.printVendorData();
        System.out.println("********************************************************");
        OrderDAO orderDAO = new OrderDAO();
//        orderDAO.createTable();

        // CustomerId = 1001, 1002, 1003
        // VendorId = 2001,2002,2003
        // orderId = 3001, 3002, 3003
        Random rand = new Random();
        int min = 200;
        int max = 2000;
        for(int i = 1; i < 100; i++) {
            Order order = new Order();
            // order fields set
            order.setStatus(OrderStatus.NEW);
            order.setCustomerId(1000 + i);
            order.setVendorId(2000 + i);
            order.setId(3000 + i);
            order.setDeliveryAddress("Nagpur");
            int randomPrice = rand.nextInt((max - min) + 1) + min;
            order.setTotalPrice(randomPrice);
            order.setOrderDate(new Date());
            System.out.println();
            orderDAO.insertOrder(order);
        }



    }
}
