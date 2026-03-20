# Design Evaluation

The PriceCalculator class has a design that is difficult to maintain and extend.

First, it violates the Open/Closed Principle because every time a new customer type or discount is added, the calculatePrice method must be modified. This makes the class not closed for modification.

Second, the class uses multiple conditional statements (if statements) to determine behavior. As the number of customer types grows, the method becomes more complex and harder to manage.

Third, the design is not scalable. Adding new pricing strategies requires changing existing code instead of adding new classes.

Fourth, there is no separation of concerns. The class handles all pricing logic instead of delegating different pricing behaviors to separate components.

Overall, this design leads to poor maintainability, low flexibility, and increased risk of errors when changes are made.
