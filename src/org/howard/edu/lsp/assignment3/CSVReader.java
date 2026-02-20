package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for reading products from a CSV file.
 */
public class CSVReader {

    /**
     * Reads products from the specified CSV file.
     *
     * @param filePath the path to the input CSV file
     * @return a list of Product objects
     */
    public List<Product> readProducts(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    continue; // Skip invalid row
                }

                try {
                    double price = Double.parseDouble(parts[2].trim());

                    Product product = new Product(
                            parts[0].trim(),
                            parts[1].trim(),
                            price,
                            parts[3].trim()
                    );

                    products.add(product);

                } catch (NumberFormatException e) {
                    // Skip rows with invalid price
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }
}
