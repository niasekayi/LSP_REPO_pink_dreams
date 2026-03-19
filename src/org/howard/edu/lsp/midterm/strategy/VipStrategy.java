package org.howard.edu.lsp.midterm.strategy;

/**
 * VIP discount strategy.
 */
public class VipStrategy implements PricingStrategy {

    public double calculate(double price) {
        return price * 0.80;
    }
}