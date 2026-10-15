package com.hcldailytask.bankApplication.app;

import com.hcldailytask.bankApplication.model.BankAccount;
import com.hcldailytask.bankApplication.service.DepositService;
import com.hcldailytask.bankApplication.service.LoginService;
import com.hcldailytask.bankApplication.service.WithdrawService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LoginService login = new LoginService();
        BankAccount userAcc = new BankAccount();
        DepositService depositService = new DepositService(userAcc);
        WithdrawService withdrawService = new WithdrawService(userAcc);
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the 4 Digit pin to continue: ");
            int pass = in.nextInt();
            if(login.validateCredentials(pass)) {
                break;
            }
            else if (i == 2) {
                System.out.println("Account is locked temporarily! Please try again after some time.");
            }
        }

        while (login.userLoggedin()) {
            System.out.println("1. Check balance");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Deposit cash");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int ch = in.nextInt();

            switch (ch) {
                case 1:
                    System.out.println(userAcc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double amt = in.nextDouble();
                    withdrawService.withdrawAmount(amt);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double amount = in.nextDouble();
                    depositService.depositAmount(amount);
                    break;
                case 4:
                    System.out.println("Thankyou! Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, Please try again.");
            }
        }
    }
}
