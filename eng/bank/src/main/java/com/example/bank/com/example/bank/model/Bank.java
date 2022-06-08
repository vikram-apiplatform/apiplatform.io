package com.example.bank.com.example.bank.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "bank")
public class Bank {

    @Id
    private String id;
    private String customer_name;
    private Integer account_no;
    private String email;
    private String phone;
    private Integer balance;
    
    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
    public Integer getAccount_no() {
        return account_no;
    }

    public void setAccount_no(Integer account_no) {
        this.account_no = account_no;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
