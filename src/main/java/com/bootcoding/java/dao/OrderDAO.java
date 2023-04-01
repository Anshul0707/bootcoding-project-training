package com.bootcoding.java.dao;

import com.bootcoding.java.model.Order;
import com.bootcoding.java.model.OrderStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class OrderDAO {
    private Connection conn;

    private static final String TABLE_NAME="customer_order";

    public OrderDAO() {
        DAOService daoService = new DAOService();
        conn = daoService.getDatabaseConnections();
    }

    public  void createTable()
    {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("CREATE TABLE IF NOT EXISTS ");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append("id bigint NOT NULL,");
        queryBuilder.append("customerid bigint,");
        queryBuilder.append("vendorid bigint,");
        queryBuilder.append("totalprice numeric,");
        queryBuilder.append("deliveryaddress character varying,");
        queryBuilder.append("status character varying,");
        queryBuilder.append("order_date timestamp without time zone");
        queryBuilder.append(" ) ");
        queryBuilder.append(" ; ");
        System.out.println(queryBuilder.toString());

        try
        {
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryBuilder.toString());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public void insertOrder(Order order)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("insert into "+ TABLE_NAME
            + " values(?,?,?,?,?,?,?)");
            statement.setLong(1, order.getId());
            statement.setLong(2, order.getCustomerId());
            statement.setLong(3,order.getVendorId());
            statement.setDouble(4,order.getTotalPrice());
            statement.setString(5, order.getDeliveryAddress());
            statement.setString(6,order.getStatus().name());
            statement.setTimestamp(7, new Timestamp(order.getOrderDate().getTime()));

            statement.executeUpdate();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
    public List<Order> getAllOrders()
    {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from \"Bootcoding\".order");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                long customerId = resultSet.getLong("customerid");
                long vendorId = resultSet.getLong("vendorid");
                double totalprice = resultSet.getDouble("totalprice");
                String deliveryAddress = resultSet.getString("deliveryaddress");
                String status = resultSet.getString("status");
                Date order_date = new Date(resultSet.getLong("order_date"));




                Order order = new Order();
                order.setTotalPrice(totalprice);
                order.setDeliveryAddress(deliveryAddress);
                order.setCustomerId(customerId);

                order.setVendorId(vendorId);
                orders.add(order);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orders;
    }
}
