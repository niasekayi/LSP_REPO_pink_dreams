package org.howard.edu.lsp.midterm.strategy;

/**
 * Holiday discount strategy.
 */
public class HolidayStrategy implements PricingStrategy {

    public double calculate(double price) {
        return price * 0.85;
    }
}