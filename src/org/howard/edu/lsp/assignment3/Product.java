package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a single product record from the input CSV.
 * This class encapsulates the core fields that appear in the input and output.
 */
public class Product {
    private final int productId;
    private final String name;
    private final BigDecimal price;
    private final String category;

    /**
     * Constructs a Product.
     *
     * @param productId Product ID as an integer
     * @param name      Product name
     * @param price     Product price (not null)
     * @param category  Product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return the product category
     */
    public String getCategory() {
        return category;
    }
}