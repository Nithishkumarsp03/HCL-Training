package com.hcldailytask.bankApplication.model;

public class BankAccount {
    private final int accno;
    private double balance;
    private final String name;

    public BankAccount(int accno, double balance, String name) {
        this.accno = accno;
        this.balance = balance;
        this.name = name;
    }

    public BankAccount() {
        this(1234567890, 10000.00, "Rajinikanth");
    }

    public int getAccno () {
        return accno;
    }
    public double getBalance() {
        return balance;
    }
    public String getName () {
        return name;
    }
    public void setBalance (double amt) {
        this.balance = amt;
    }
}
