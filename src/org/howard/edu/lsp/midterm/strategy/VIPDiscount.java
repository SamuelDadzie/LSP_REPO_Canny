package org.howard.edu.lsp.midterm.strategy;

/**
 * VIP discount (20% off).
 * @author Samuel Dadzie
 */
public class VIPDiscount implements DiscountStrategy {

    /**
     * Applies 20% discount.
     */
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}
