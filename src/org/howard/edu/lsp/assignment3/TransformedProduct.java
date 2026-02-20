package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a transformed product record ready to be written to the output CSV.
 */
public class TransformedProduct {
    private final int productId;
    private final String name;
    private final BigDecimal price;
    private final String category;
    private final String priceRange;

    /**
     * Constructs a transformed product.
     *
     * @param productId   product ID
     * @param name        transformed name
     * @param price       final rounded price
     * @param category    final category
     * @param priceRange  computed price range label
     */
    public TransformedProduct(int productId, String name, BigDecimal price, String category, String priceRange) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    /**
     * @return product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @return transformed name
     */
    public String getName() {
        return name;
    }

    /**
     * @return final rounded price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return final category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return price range label
     */
    public String getPriceRange() {
        return priceRange;
    }
}