# Design Evaluation

The OrderProcessor class has several design problems that violate object-oriented principles.

First, it has poor encapsulation because all fields (customerName, email, item, price) are public. This allows direct access and modification from outside the class, which breaks data hiding.

Second, the class violates the Single Responsibility Principle. It performs multiple unrelated tasks such as calculating totals, printing receipts, writing to a file, sending emails, applying discounts, and logging. This makes the class too complex and hard to maintain.

Third, the class is tightly coupled to specific implementations. For example, it directly uses FileWriter for file storage and System.out.println for output. This makes it difficult to change how data is stored or displayed.

Fourth, the logic is not modular. All operations are inside one method (processOrder), making it hard to reuse or extend individual behaviors like discount calculation or email sending.

Fifth, there is no clear separation of concerns. Business logic, I/O operations, and logging are all mixed together, which reduces flexibility and testability.

Overall, this design leads to poor maintainability, low reusability, and difficulty in extending the system.