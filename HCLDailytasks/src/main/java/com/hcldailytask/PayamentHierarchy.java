package com.hcldailytask;

abstract class PaymentHierarchy {
    protected double amount;

    public PaymentHierarchy(double amount) {
        this.amount = amount;
    }

    public abstract void pay();

    // Overloaded method
    public void pay(String transactionId) {
        System.out.println("Transaction: " + transactionId);
        pay();
    }
}

interface Refundable {
    void refund(double amount);
}

class CardPayment extends PaymentHierarchy implements Refundable {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid by Card: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Card refund: " + amount);
    }
}

class UPIPayment extends PaymentHierarchy {
    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid by UPI: " + amount);
    }
}

class CashPayment extends PaymentHierarchy {
    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paid by Cash: " + amount);
    }
}
