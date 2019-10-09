package com.lambdaschool.orders.models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderid;

    @Column (unique = true,
             nullable = false)
    private double orderAmount;
    private double advanceAmount;
    private String orderDescription;

    //
    @ManyToOne
    @JoinColumn(name = "customerid",
                nullable = false)
    private Customer customer;

    //Default constructor needed if its an Entity
    public Order()
    {
    }

    //Constructors
    public Order(double orderAmount, double advanceAmount, String orderDescription) {
        this.orderAmount = orderAmount;
        this.advanceAmount = advanceAmount;
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
}
