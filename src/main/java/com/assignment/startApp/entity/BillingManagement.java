package com.assignment.startApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_management")

public class BillingManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bill_name")
    private String billName;

    @Column(name = "bill_amount")
    private Integer billAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public Integer getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Integer billAmount) {
		this.billAmount = billAmount;
	}
}
