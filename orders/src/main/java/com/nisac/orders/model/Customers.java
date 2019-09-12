package com.nisac.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="customers")
public class Customers
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custCode;

    @Column(nullable = false)
    private String custName;

    @Column
    private String custCity;

    @Column
    private String workingArea;

    @Column
    private String custCountry;

    @Column
    private String grade;

    @Column
    private double openingAmt;

    @Column
    private double receiveAmt;

    @Column
    private double paymentAmt;

    @Column
    private double outstandingAmt;

    @Column
    private String phone;

    @OneToMany(mappedBy = "customer",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnoreProperties("customer")
    private List<Orders> orders = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agentCode", nullable = false)
    @JsonIgnoreProperties("customers")
    private Agents agent;

    public Customers()
    {}

    public Customers(String custName,
                     String custCity,
                     String workingArea,
                     String custCountry,
                     String grade,
                     double openingAmt,
                     double receiveAmt,
                     double paymentAmt,
                     double outstandingAmt,
                     String phone,
                     Agents agent) {
        this.custName = custName;
        this.custCity = custCity;
        this.workingArea = workingArea;
        this.custCountry = custCountry;
        this.grade = grade;
        this.openingAmt = openingAmt;
        this.receiveAmt = receiveAmt;
        this.paymentAmt = paymentAmt;
        this.outstandingAmt = outstandingAmt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustCode() {
        return custCode;
    }

    public void setCustCode(long custCode) {
        this.custCode = custCode;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }

    public void setPaymentAmt(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
