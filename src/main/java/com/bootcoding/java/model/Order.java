package com.bootcoding.java.model;

import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private long CustomerId;
    private long VendorId;
    private double TotalPrice;
    private String deliveryAddress;
    private OrderStatus status;
    private List<MenuItem> menuItems;
    private Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }

    public long getVendorId() {
        return VendorId;
    }

    public void setVendorId(long vendorId) {
        VendorId = vendorId;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void print(){
        System.out.println(getId());
        System.out.println(getCustomerId());
        System.out.println(getVendorId());
        System.out.println(getDeliveryAddress());
        System.out.println(getTotalPrice());
        System.out.println(getStatus());
    }
}
