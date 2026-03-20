package org.howard.edu.lsp.midterm.strategy;

/**
 * Regular customer discount (no discount).
 * @author Samuel Dadzie
 */
public class RegularDiscount implements DiscountStrategy {

    /**
     * Applies no discount.
     */
    public double applyDiscount(double price) {
        return price;
    }
}
