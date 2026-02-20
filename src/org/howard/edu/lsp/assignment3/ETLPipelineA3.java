package org.howard.edu.lsp.assignment3;

/**
 * Entry point for Assignment 3 ETL pipeline.
 */
public class ETLPipelineA3 {

    /**
     * Runs the ETL pipeline using the required relative paths.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        FileProcessor processor = new FileProcessor();
        processor.process(inputPath, outputPath);
    }
}