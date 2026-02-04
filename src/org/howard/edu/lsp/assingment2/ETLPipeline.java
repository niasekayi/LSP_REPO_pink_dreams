package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * Name: Niagreene
 */

public class ETLPipeline {
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Error: Input file " + inputPath + " not found.");
            return;
        }

        // Ensure output directory exists
        File outputDir = new File("data");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            // Read and discard header from input (if present)
            String header = reader.readLine();

            // Always write fixed header to output
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String productIdStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                int productId;
                BigDecimal price;

                try {
                    productId = Integer.parseInt(productIdStr);
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                // Transformations

                // 1. Convert name to UPPERCASE
                String transformedName = name.toUpperCase();

                // Keep track of original category
                String originalCategory = category;
                boolean isElectronicsOriginal = "Electronics".equals(originalCategory);

                // 2. If category is "Electronics", apply 10% discount
                BigDecimal finalPrice = price;
                if (isElectronicsOriginal) {
                    finalPrice = price.multiply(new BigDecimal("0.9"));
                }

                // Round to exactly two decimal places, HALF_UP
                finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);

                // 3. If final rounded price > 500.00 AND original category was "Electronics",
                //    change category to "Premium Electronics"
                String finalCategory = originalCategory;
                if (isElectronicsOriginal && finalPrice.compareTo(new BigDecimal("500.00")) > 0) {
                    finalCategory = "Premium Electronics";
                }

                // 4. Add PriceRange based on final rounded price
                String priceRange;
                BigDecimal ten = new BigDecimal("10.00");
                BigDecimal hundred = new BigDecimal("100.00");
                BigDecimal fiveHundred = new BigDecimal("500.00");

                if (finalPrice.compareTo(ten) <= 0) {
                    priceRange = "Low";
                } else if (finalPrice.compareTo(ten) > 0 && finalPrice.compareTo(hundred) <= 0) {
                    priceRange = "Medium";
                } else if (finalPrice.compareTo(hundred) > 0 && finalPrice.compareTo(fiveHundred) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                // Write transformed row
                writer.write(productId + "," +
                             transformedName + "," +
                             finalPrice.toPlainString() + "," +
                             finalCategory + "," +
                             priceRange);
                writer.newLine();
                rowsTransformed++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file " + inputPath + " not found.");
            return;
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
            return;
        }

        rowsSkipped = rowsRead - rowsTransformed;

        // Run summary
        System.out.println("Run Summary:");
        System.out.println("Rows read (non-header): " + rowsRead);
        System.out.println("Rows transformed (written): " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + outputPath);
    }
}