package org.howard.edu.lsp.midterm.strategy;

/**
 * Regular pricing strategy (no discount).
 */
public class RegularStrategy implements PricingStrategy {

    public double calculate(double price) {
        return price;
    }
}