package org.howard.edu.lsp.assignment3;

/**
 * Applies transformation rules to Product objects.
 */
public class ProductTransformer {

    /**
     * Transforms a product according to assignment rules.
     *
     * @param product the product to transform
     */
    public void transform(Product product) {

        // Fix negative price
        if (product.getPrice() < 0) {
            product.setPrice(0.0);
        }

        // Capitalize product name
        String name = product.getName();
        if (name != null && !name.isEmpty()) {
            name = name.substring(0, 1).toUpperCase() +
                   name.substring(1).toLowerCase();
            product.setName(name);
        }

        // Determine price range
        double price = product.getPrice();
        String priceRange;

        if (price <= 10) {
            priceRange = "Low";
        } else if (price <= 100) {
            priceRange = "Medium";
        } else {
            priceRange = "High";
        }

        product.setPriceRange(priceRange);
    }
}
