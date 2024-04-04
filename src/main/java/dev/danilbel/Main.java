package dev.danilbel;

import java.util.Arrays;

public class Main {

    static class Laptop {
        double price;
        double gain;
        double profit;

        public Laptop(double gain, double price) {
            this.gain = gain;
            this.price = price;
            this.profit = gain - price;
        }
    }

    private static double calculateCapital(double n, double capital, double[] gains, double[] prices) {
        Laptop[] laptops = new Laptop[gains.length];
        for (int i = 0; i < laptops.length; i++) {
            laptops[i] = new Laptop(gains[i], prices[i]);
        }
        Arrays.sort(laptops, (a, b) -> Double.compare(b.profit, a.profit));

        int bought = 0;
        double sum = 0;
        for (int i = 0; i < laptops.length && bought < n; i++) {
            if (capital >= laptops[i].price) {
                capital -= laptops[i].price;
                sum += laptops[i].gain;
                bought++;
            }
        }

        return capital + sum;
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Usage: java -jar build/libs/students-capital-1.0.jar <N> <C> <gains_array> <prices_array>\n" +
                    "Example: java -jar build/libs/students-capital-1.0.jar 3 100 \"30, 40.50, 70.39, 20, 10\" \"10, 20.2, 50.50, 15, 7\"");
            return;
        }

        int n = Integer.parseInt(args[0]);
        if (n < 0) {
            System.err.println("Error:\nN must be a positive number");
            return;
        }

        int capital = Integer.parseInt(args[1]);
        if (capital < 0) {
            System.err.println("Error:\nC must be a positive number");
            return;
        }

        String[] gainsStr = args[2].split(",");
        String[] pricesStr = args[3].split(",");
        if (gainsStr.length != pricesStr.length) {
            System.err.println("Error:\nGains and prices arrays must have the same length");
            return;
        }

        double[] gains = new double[gainsStr.length];
        double[] prices = new double[pricesStr.length];
        try {
            for (int i = 0; i < gainsStr.length; i++) {
                gains[i] = Double.parseDouble(gainsStr[i].trim());
                prices[i] = Double.parseDouble(pricesStr[i].trim());
            }
        } catch (NumberFormatException e) {
            System.err.println("Error:\nGains and prices arrays must contain only numbers.\n" +
                    "Numbers should be separated by commas.\n" +
                    "Double values should have a dot as a decimal separator.");
            return;
        }

        System.out.println("Capital: " + calculateCapital(n, capital, gains, prices));
    }
}