package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for discount calculation.
 * @author Samuel Dadzie
 */
public interface DiscountStrategy {
    double applyDiscount(double price);
}