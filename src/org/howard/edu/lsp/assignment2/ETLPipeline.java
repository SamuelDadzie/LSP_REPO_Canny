package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String header = reader.readLine();

            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            if (header == null) {
                System.out.println("Run Summary:");
                System.out.println("Rows read: 0");
                System.out.println("Rows transformed: 0");
                System.out.println("Rows skipped: 0");
                System.out.println("Output file: " + outputPath);
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int productID = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim().toUpperCase();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();
                    String originalCategory = category;

                    if (category.equals("Electronics")) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    price = price.setScale(2, RoundingMode.HALF_UP);

                    if (price.compareTo(new BigDecimal("500.00")) > 0 &&
                        originalCategory.equals("Electronics")) {
                        category = "Premium Electronics";
                    }

                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    writer.write(productID + "," + name + "," + price.toString() + "," + category + "," + priceRange);
                    writer.newLine();
                    rowsTransformed++;

                } catch (Exception ex) {
                    rowsSkipped++;
                }
            }

            System.out.println("Run Summary:");
            System.out.println("Rows read: " + rowsRead);
            System.out.println("Rows transformed: " + rowsTransformed);
            System.out.println("Rows skipped: " + rowsSkipped);
            System.out.println("Output file: " + outputPath);

        } catch (IOException ex) {
            System.out.println("ERROR processing file.");
        }
    }
}
