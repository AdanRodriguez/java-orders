package com.lambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerid;

    @Column(unique = true,
            nullable = false)
    private String customerName;
    private String customerCity;
    private String workingArea;
    private String customerCountry;
    private String grade;
    private double openingAtm;
    private double receiveAtm;
    private double paymentAtm;
    private double outstandingAtm;
    private String phone;

    //Many to One --- 1 agent/ many customers
    @ManyToOne
    @JoinColumn(name = "agentid",
                nullable = false)
    @JsonIgnoreProperties("customer")
    private Agent agent;

    //One to many ---- 1 customer/ many orders
    @OneToMany(mappedBy = "customer",
               cascade = CascadeType.ALL)
    @JsonIgnoreProperties("customer")
    private List<Order> orders = new ArrayList<>();


    //Default constructor needed if its an Entity

    public Customer()
    {
    }

    //Constructors
    public Customer(String customerName, String customerCity, String workingArea, String customerCountry, String grade, double openingAtm, double receiveAtm, double paymentAtm, double outstandingAtm, String phone, Agent agent) {
        this.customerName = customerName;
        this.customerCity = customerCity;
        this.workingArea = workingArea;
        this.customerCountry = customerCountry;
        this.grade = grade;
        this.openingAtm = openingAtm;
        this.receiveAtm = receiveAtm;
        this.paymentAtm = paymentAtm;
        this.outstandingAtm = outstandingAtm;
        this.phone = phone;
        this.agent = agent;
    }

    //Getters and Setters
    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAtm() {
        return openingAtm;
    }

    public void setOpeningAtm(double openingAtm) {
        this.openingAtm = openingAtm;
    }

    public double getReceiveAtm() {
        return receiveAtm;
    }

    public void setReceiveAtm(double receiveAtm) {
        this.receiveAtm = receiveAtm;
    }

    public double getPaymentAtm() {
        return paymentAtm;
    }

    public void setPaymentAtm(double paymentAtm) {
        this.paymentAtm = paymentAtm;
    }

    public double getOutstandingAtm() {
        return outstandingAtm;
    }

    public void setOutstandingAtm(double outstandingAtm) {
        this.outstandingAtm = outstandingAtm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }
}
