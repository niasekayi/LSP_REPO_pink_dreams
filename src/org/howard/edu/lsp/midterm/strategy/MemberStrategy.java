package org.howard.edu.lsp.midterm.strategy;

/**
 * Member discount strategy.
 */
public class MemberStrategy implements PricingStrategy {

    public double calculate(double price) {
        return price * 0.90;
    }
}