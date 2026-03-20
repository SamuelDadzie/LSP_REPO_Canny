package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver to test Strategy Pattern implementation.
 * @author Samuel Dadzie
 */
public class Driver {

    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();

        // REGULAR
        calculator.setStrategy(new RegularDiscount());
        System.out.println("REGULAR: " + calculator.calculatePrice(100.0));

        // MEMBER
        calculator.setStrategy(new MemberDiscount());
        System.out.println("MEMBER: " + calculator.calculatePrice(100.0));

        // VIP
        calculator.setStrategy(new VIPDiscount());
        System.out.println("VIP: " + calculator.calculatePrice(100.0));

        // HOLIDAY
        calculator.setStrategy(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(100.0));
    }
}