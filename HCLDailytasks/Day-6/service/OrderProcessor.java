package com.hcldailytask.orderService.service;
import com.hcldailytask.orderService.exceptions.InvalidQuantityException;
import com.hcldailytask.orderService.exceptions.InsufficientStockException;

public class OrderProcessor {

    private int stock = 10;

    public void processOrder(int quantity)
            throws InsufficientStockException {

        try {
            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than zero"
                );
            }

            if (quantity > stock) {
                throw new InsufficientStockException(
                        "Insufficient stock. Available: " + stock
                );
            }

            stock -= quantity;
            System.out.println("Order successful!");
            System.out.println("Remaining stock: " + stock);

        } catch (InvalidQuantityException |
                 InsufficientStockException e) {

            System.err.println("Order failed: " + e.getMessage());
            throw e;

        } finally {
            System.out.println("AUDIT: Order processing attempted");
        }
    }
}
