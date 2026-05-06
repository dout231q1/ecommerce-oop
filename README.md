# ecommerce-oop

A simulated e-commerce store system built with **Java**, using only Object-Oriented Programming concepts. This project was built as a portfolio piece to demonstrate core OOP principles without frameworks, databases, or graphical interfaces.

## Key Concepts Applied

- **Encapsulation** — all attributes are `private` with controlled access via getters
- **Inheritance** — `Electronics`, `Clothing` and `Food` extend `Product`
- **Polymorphism** — `PixPayment`, `CreditCardPayment` and `BoletoPayment` implement `PaymentMethod`
- **Lambda** — used in `Cart.removeProduct()` with `removeIf`

## Features

- Product catalog with multiple product types
- Add and remove products from cart
- Display cart contents and total price
- Balance validation before checkout
- 3 payment methods with different behaviors:
  - Pix — instant payment, no extra charge
  - Boleto — fixed payment, no extra charge
  - Credit Card — applies 5% tax on the total
- Balance correctly discounted after purchase, including credit card tax
- `CartTest` class to manually demonstrate additional cart operations outside the standard purchase flow

## Project Structure
```
src/
├── Main.java              # Entry point
├── CartTest.java          # Manual demonstration of additional cart operations
│
├── Product.java           # Base class
├── Electronics.java       # Extends Product
├── Clothing.java          # Extends Product
├── Food.java              # Extends Product
│
├── Cart.java              # Cart logic
├── User.java              # User and balance management
│
├── PaymentMethod.java     # Interface for payment types
├── PixPayment.java        # Implements PaymentMethod
├── BoletoPayment.java     # Implements PaymentMethod
└── CreditCardPayment.java # Implements PaymentMethod (5% tax)
```

## Requirements

- [JDK 17+](https://www.oracle.com/java/technologies/downloads/)

## How to Run

```bash
# Clone the repository
git clone https://github.com/dout231q1/ecommerce-oop

# Navigate to the project folder
cd ecommerce-oop

# Compile
javac src/*.java -d out

# Run
java -cp out Main
```

## Example Output

```
=== Products Display ===
Name: Keyboard, Price: $80.0
Name: Mouse, Price: $60.0
Name: TV, Price: $200.0, Warranty (In months): 24
Name: PC, Price: $2500.0, Warranty (In months): 12
Name: T-Shirt, Price: $25.0, Clothing Size: G
Name: Jeans, Price: $55.0, Clothing Size: M
Name: Frozen Pizza, Price: $7.0, Expiration Date: 2026-05-10
Name: Doritos, Price: $12.0, Expiration Date: 2026-06-15

=== Cart ===
Name: Keyboard, Price: $80.0
Name: Mouse, Price: $60.0
Name: T-Shirt, Price: $25.0
Total price: $165.0

=== Payment ===
Balance: $500.0
Calculating credit card tax...
Tax amount: $8.25 plus product's total: $165.0
Done!
$173.25 payment made via Credit Card.
Remaining balance: $326.75
```

## Future Improvements

- Add product quantity support
- Implement discount coupons
- Add shipping calculation
- Extend as a REST API using Spring Boot
