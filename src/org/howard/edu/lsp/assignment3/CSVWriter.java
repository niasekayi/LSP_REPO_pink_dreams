package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Responsible for writing products to a CSV file.
 */
public class CSVWriter {

    /**
     * Writes products to the specified output CSV file.
     *
     * @param filePath the output file path
     * @param products the list of products to write
     */
    public void writeProducts(String filePath, List<Product> products) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            for (Product product : products) {
                bw.write(product.getProductId() + "," +
                         product.getName() + "," +
                         product.getPrice() + "," +
                         product.getCategory() + "," +
                         product.getPriceRange());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
