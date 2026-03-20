package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday discount (15% off).
 * @author Samuel Dadzie
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies 15% discount.
     */
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}
