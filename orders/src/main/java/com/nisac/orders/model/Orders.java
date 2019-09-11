package com.nisac.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordNum;

    @Column
    private double ordAmount;

    @Column
    private double advanceAmount;

    @ManyToOne
    @JoinColumn(name = "custCode", nullable =  false)
    @JsonIgnore
    private Customers custCode;

    @Column
    private String ordDescription;

    public Orders()
    {}

    public Orders(double ordAmount,
                  double advanceAmt,
                  Customers custCode,
                  String ordDescription) {
        this.ordAmount = ordAmount;
        this.advanceAmount = advanceAmt;
        this.custCode = custCode;
        this.ordDescription = ordDescription;
    }

    public long getOrdNum() {
        return ordNum;
    }

    public void setOrdnum(long ordnum) {
        this.ordNum = ordnum;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmt) {
        this.advanceAmount = advanceAmt;
    }

    public String getOrdDescription() {
        return ordDescription;
    }

    public void setOrdDescription(String ordDescription) {
        this.ordDescription = ordDescription;
    }

    public Customers getCustomer() {
        return custCode;
    }

    public void setCustomer(Customers custCode) {
        this.custCode = custCode;
    }
}
