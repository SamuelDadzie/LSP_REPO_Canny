package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Handles file input and output for the ETL pipeline.
 */
public class FileProcessor {

    /**
     * Processes the input file and writes transformed output.
     *
     * @param inputPath  path to input CSV
     * @param outputPath path to output CSV
     */

    /**
 * Executes the ETL process:
 * Reads input, transforms records, writes output,
 * and prints the run summary.
 *
 * @param inputPath relative path to input CSV
 * @param outputPath relative path to output CSV
 */
    public void process(String inputPath, String outputPath) {

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        ProductTransformer transformer = new ProductTransformer();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String header = reader.readLine();

            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            if (header == null) {
                printSummary(rowsRead, rowsTransformed, rowsSkipped, outputPath);
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
                    int productId = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();

                    Product product = new Product(productId, name, price, category);
                    TransformedProduct transformed = transformer.transform(product);

                    writer.write(
                            transformed.getProductId() + "," +
                            transformed.getName() + "," +
                            transformed.getPrice().toString() + "," +
                            transformed.getCategory() + "," +
                            transformed.getPriceRange()
                    );

                    writer.newLine();
                    rowsTransformed++;

                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

            printSummary(rowsRead, rowsTransformed, rowsSkipped, outputPath);

        } catch (IOException e) {
            System.out.println("ERROR processing file.");
        }
    }

    /**
     * Prints the run summary.
     */
    private void printSummary(int rowsRead, int rowsTransformed, int rowsSkipped, String outputPath) {
        System.out.println("Run Summary:");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + outputPath);
    }
}