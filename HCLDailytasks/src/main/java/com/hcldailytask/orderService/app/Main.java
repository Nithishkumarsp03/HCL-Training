package com.hcldailytask.orderService.app;
import java.util.*;
import com.hcldailytask.orderService.service.*;
import com.hcldailytask.orderService.exceptions.InsufficientStockException;
import com.hcldailytask.orderService.exceptions.InvalidQuantityException;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderProcessor processor = new OrderProcessor();

        while (true) {
            try {
                System.out.print("Enter quantity (0 to exit): ");
                int quantity = Integer.parseInt(scanner.nextLine());

                if (quantity == 0) {
                    break;
                }

                processor.processOrder(quantity);

            } catch (InsufficientStockException |
                     InvalidQuantityException e) {

                System.out.println("Please try again: " + e.getMessage());

            } catch (NumberFormatException e) {
                System.out.println("Enter a valid whole number.");
            }
        }
    }
}
