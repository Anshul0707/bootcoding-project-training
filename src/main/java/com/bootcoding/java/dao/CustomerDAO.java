package com.bootcoding.java.dao;

import com.bootcoding.java.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAO
{
    private Connection conn;

    public CustomerDAO()
    {
        DAOService daoService = new DAOService();
        conn = daoService.getDatabaseConnections();
    }

    public List<Customer> getAllCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from \"Bootcoding\".customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                String name = resultSet.getString("name");
                String emailId = resultSet.getString("emailId");
                String password = resultSet.getString("password");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String deliveryAddress = resultSet.getString("deliveryAddress");
                Date createdAt = new Date(resultSet.getLong("createdAt"));
                Date modifiedAt = new Date(resultSet.getLong("modifiedAt"));

                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmailId(emailId);
                customer.setPassword(password);
                customer.setCity(city);
                customer.setState(state);
                customer.setDeliveryAddress(deliveryAddress);

                customers.add(customer);


            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return customers ;
    }


}
