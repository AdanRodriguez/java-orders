package com.lambdaschool.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;

    private double orderAmount;
    private double advanceAmount;
    private String orderDescription;

    //Many to One --- Many orders to 1 customer
    @ManyToOne
    @JoinColumn(name = "customerid",
                nullable = false)
    private Customer customer;

    //Default constructor needed if its an Entity
    public Order()
    {
    }

    //Constructors
    public Order(double orderAmount, double advanceAmount,Customer customer, String orderDescription)
    {
        this.orderAmount = orderAmount;
        this.advanceAmount = advanceAmount;
        this.customer = customer;
        this.orderDescription = orderDescription;
    }


    //Getters and Setters
    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
