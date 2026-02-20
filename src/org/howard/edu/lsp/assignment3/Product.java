package org.howard.edu.lsp.assignment3;
/**
 * Represents a product from the CSV file.
 * Encapsulates product data including ID, name, price,
 * category, and price range.
 */
public class Product {

    private String productId;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    /**
     * Constructs a Product object.
     *
     * @param productId the product ID
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(String productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}