package com.hcldailytask.bankApplication.service;
import com.hcldailytask.bankApplication.model.BankAccount;

public class WithdrawService {
    private final BankAccount userAcc;
    public WithdrawService (BankAccount userAcc) {
        this.userAcc = userAcc;
    }

    double getBalance () {
        return userAcc.getBalance();
    }

    public void withdrawAmount (double amount) {
        double balance = getBalance();
        if(balance < amount) {
            System.out.println("Insufficient balance: "+balance);
        }
        else {
            balance -= amount;
            userAcc.setBalance(balance);
            System.out.println(amount+" withdrawed successfully. Available balance: "+balance);
        }
    }
}
