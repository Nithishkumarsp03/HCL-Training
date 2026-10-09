package com.hcldailytask.bankApplication.service;
import com.hcldailytask.bankApplication.model.BankAccount;

public class DepositService {
    private final BankAccount userAcc;
    public DepositService (BankAccount userAcc) {
        this.userAcc=userAcc;
    }

    double getBalance () {
        return userAcc.getBalance();
    }

    public void depositAmount (double amount) {
    double balance = getBalance();
        balance += amount;
        userAcc.setBalance(balance);
        System.out.println(amount+" deposited successfully! Available balance: "+balance);
    }
}
