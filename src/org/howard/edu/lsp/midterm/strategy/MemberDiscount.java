package org.howard.edu.lsp.midterm.strategy;

/**
 * Member discount (10% off).
 * @author Samuel Dadzie
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies 10% discount.
     */
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}
