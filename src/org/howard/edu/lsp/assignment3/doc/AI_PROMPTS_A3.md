# AI Prompts and Responses (Assignment 3)

## Prompt 1

I finished Assignment 2 as a single class ETL pipeline. Help me redesign it to be more object oriented, but keep the exact same behavior, inputs, outputs, transformations, and error handling. Suggest classes and responsibilities.

## AI Response 1

Suggested splitting responsibilities into multiple classes:

* A main runner class as the entry point
* A class to represent a Product (input record)
* A class to represent a TransformedProduct (output record)
* A Transformer class to apply transformation rules
* A FileProcessor or Pipeline class to handle reading and writing

## Prompt 2

Generate Java class skeletons for Product, TransformedProduct, ProductTransformer, FileProcessor, and a main entry class under package org.howard.edu.lsp.assignment3. Use only standard Java libraries. Include Javadocs for classes and public methods.

## AI Response 2

Provided Java class templates with:

* private fields and getters for Product and TransformedProduct
* transform method and price range helper in ProductTransformer
* process method with row skipping rules in FileProcessor
* main method in ETLPipelineA3 that calls FileProcessor

## Prompt 3

Confirm that the transformation order is exactly:
1 uppercase name
2 Electronics discount
3 round half up to 2 decimals
4 Premium Electronics rule using final rounded price and original category
5 compute PriceRange using final rounded price

## AI Response 3

Confirmed the order and advised rounding must happen before Premium Electronics and PriceRange decisions.

## Prompt 4

Help me verify compilation and runtime behavior on a Mac terminal, and confirm the output matches Assignment 2.

## AI Response 4

Provided terminal commands to compile and run, and recommended comparing the output CSV files to confirm identical results.