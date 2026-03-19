# Improved Design (CRC Cards)

Class: Order
Responsibilities:
- Store order details (customerName, email, item, price)
- Provide access to order data

Collaborators:
- OrderProcessor

---

Class: OrderProcessor
Responsibilities:
- Coordinate order processing
- Call services for tax, discount, and logging

Collaborators:
- Order
- PaymentService
- DiscountService
- EmailService
- FileService
- Logger

---

Class: PaymentService
Responsibilities:
- Calculate total price including tax

Collaborators:
- Order

---

Class: DiscountService
Responsibilities:
- Apply discount rules

Collaborators:
- Order

---

Class: EmailService
Responsibilities:
- Send confirmation emails

Collaborators:
- Order

---

Class: FileService
Responsibilities:
- Save order details to file

Collaborators:
- Order

---

Class: Logger
Responsibilities:
- Log system activity

Collaborators:
- OrderProcessor