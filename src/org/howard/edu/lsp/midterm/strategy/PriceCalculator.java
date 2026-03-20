package org.howard.edu.lsp.midterm.strategy;

/**
 * Uses a discount strategy to calculate final price.
 * @author Samuel Dadzie
 */
public class PriceCalculator {

    private DiscountStrategy strategy;

    /**
     * Sets the discount strategy.
     */
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Calculates final price using selected strategy.
     */
    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}
