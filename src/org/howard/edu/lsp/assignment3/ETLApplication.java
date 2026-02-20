package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Main application class that coordinates the ETL process.
 */
public class ETLApplication {

    public static void main(String[] args) {

        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";

        CSVReader reader = new CSVReader();
        CSVWriter writer = new CSVWriter();
        ProductTransformer transformer = new ProductTransformer();

        List<Product> products = reader.readProducts(inputFile);

        int transformedCount = 0;

        for (Product product : products) {
            transformer.transform(product);
            transformedCount++;
        }

        writer.writeProducts(outputFile, products);

        System.out.println("Run Summary:");
        System.out.println("Rows read (non-header): " + products.size());
        System.out.println("Rows transformed (written): " + transformedCount);
        System.out.println("Output file: " + outputFile);
    }
}
