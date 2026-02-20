package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Applies the Assignment 2 transformation rules to products.
 */
public class ProductTransformer {

    /**
     * Transforms a product according to the required rules and returns a result
     * containing the transformed fields plus the computed price range.
     *
     * @param input the input product
     * @return transformed product result
     */
    public TransformedProduct transform(Product input) {
        String upperName = input.getName().toUpperCase();

        String originalCategory = input.getCategory();
        String finalCategory = originalCategory;

        BigDecimal finalPrice = input.getPrice();

        if (originalCategory.equals("Electronics")) {
            finalPrice = finalPrice.multiply(new BigDecimal("0.90"));
        }

        finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);

        if (finalPrice.compareTo(new BigDecimal("500.00")) > 0 && originalCategory.equals("Electronics")) {
            finalCategory = "Premium Electronics";
        }

        String priceRange = computePriceRange(finalPrice);

        return new TransformedProduct(input.getProductId(), upperName, finalPrice, finalCategory, priceRange);
    }

    /**
     * Computes the price range label based on final rounded price.
     *
     * @param price final rounded price
     * @return price range label
     */
    public String computePriceRange(BigDecimal price) {
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            return "Low";
        }
        if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            return "Medium";
        }
        if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            return "High";
        }
        return "Premium";
    }
}