package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a pricing strategy.
 */
public class PriceCalculator {

    private PricingStrategy strategy;

    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double price) {
        return strategy.calculate(price);
    }
}