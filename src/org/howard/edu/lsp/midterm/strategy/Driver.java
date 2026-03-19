package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver class to test strategy pattern.
 */
public class Driver {

    public static void main(String[] args) {

        PriceCalculator calc = new PriceCalculator();

        calc.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calc.calculate(100.0));

        calc.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calc.calculate(100.0));

        calc.setStrategy(new VipStrategy());
        System.out.println("VIP: " + calc.calculate(100.0));

        calc.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calc.calculate(100.0));
    }
}