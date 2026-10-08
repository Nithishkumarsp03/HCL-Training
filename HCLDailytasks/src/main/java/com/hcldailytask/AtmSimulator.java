package com.hcldailytask;

import java.util.Scanner;

public class AtmSimulator {

    private static final int CORRECT_PIN = 1234;
    private static final int MAX_PIN_ATTEMPTS = 3;
    private static final double INITIAL_BALANCE = 10000.00;

    private static double balance = INITIAL_BALANCE;

    private static final String[] transactions = new String[10];
    private static int transactionCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!login(scanner)) {
            System.out.println("Too many incorrect attempts. Card blocked.");
            scanner.close();
            return;
        }

        int choice=-1;

        do {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit(scanner);
                    break;

                case 3:
                    withdraw(scanner);
                    break;

                case 4:
                    showMiniStatement();
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static boolean login(Scanner scanner) {
        for (int attempt = 1; attempt <= MAX_PIN_ATTEMPTS; attempt++) {
            System.out.print("Enter PIN: ");

            if (!scanner.hasNextInt()) {
                System.out.println("PIN must contain numbers only.");
                scanner.next();
                continue;
            }

            int pin = scanner.nextInt();

            if (pin == CORRECT_PIN) {
                System.out.println("Login successful.");
                return true;
            }

            int remaining = MAX_PIN_ATTEMPTS - attempt;

            if (remaining > 0) {
                System.out.println("Incorrect PIN. Attempts remaining: " + remaining);
            }
        }

        return false;
    }

    private static void checkBalance() {
        System.out.printf("Current balance: ₹%.2f%n", balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        balance += amount;
        addTransaction("Deposited: ₹" + amount);

        System.out.println("Deposit successful.");
        checkBalance();
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");

        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid amount.");
            scanner.next();
            return;
        }

        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        addTransaction("Withdrawn: ₹" + amount);

        System.out.println("Withdrawal successful.");
        checkBalance();
    }

    private static void showMiniStatement() {
        System.out.println("\n========== MINI STATEMENT ==========");

        if (transactionCount == 0) {
            System.out.println("No transactions available.");
            return;
        }

        for (String transaction : transactions) {
            if (transaction == null) {
                break;
            }

            System.out.println(transaction);
        }

        System.out.println("====================================");
    }

    private static void addTransaction(String transaction) {
        if (transactionCount < transactions.length) {
            transactions[transactionCount++] = transaction;
        }
    }
}