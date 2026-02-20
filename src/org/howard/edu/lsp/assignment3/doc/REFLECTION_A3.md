Paste this into **REFLECTION_A3.md**:

---

# Assignment 3 Reflection

## Design Differences Between Assignment 2 and Assignment 3

In Assignment 2, the ETL pipeline logic was mostly implemented in a single class. The responsibilities for reading the file, transforming the data, and writing the output were tightly grouped together. While the program worked correctly, it was not strongly object oriented because responsibilities were not clearly separated.

In Assignment 3, the solution was redesigned using multiple classes with clearer responsibilities. The logic is now divided into the following classes:

* `ETLPipelineA3` – entry point of the program
* `FileProcessor` – handles file reading and writing
* `Product` – represents the input product data
* `ProductTransformer` – applies transformation rules
* `TransformedProduct` – represents the transformed output data

This separation makes the design more modular and easier to understand.

## How Assignment 3 Is More Object Oriented

Assignment 3 improves object orientation by applying object oriented decomposition. Each class now represents a clear concept in the system.

Encapsulation is used by keeping fields private in the `Product` and `TransformedProduct` classes and accessing them through public getter methods.

The `ProductTransformer` class demonstrates separation of responsibility by handling only transformation logic. It does not read or write files.

The `FileProcessor` class handles file operations separately from business logic.

This design improves readability, maintainability, and extensibility.

## Object Oriented Concepts Used

* **Object and Class**: Each real world concept such as Product or Transformer is represented as a class.
* **Encapsulation**: Data fields are private and accessed through methods.
* **Polymorphism**: While no inheritance hierarchy was required, the design allows transformation behavior to be extended in the future.
* **Single Responsibility Principle**: Each class has one clear responsibility.

## Testing and Validation

To confirm Assignment 3 works the same as Assignment 2, both versions were executed using the same `products.csv` input file. The output file `transformed_products.csv` was compared between the two versions.

The number of rows read, transformed, and skipped matched exactly. The generated output file content was identical to Assignment 2. This confirms that the redesign preserved all required functionality while improving structure.

---

Save the file.

Next.
