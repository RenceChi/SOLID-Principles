# Order Processing System - SOLID Refactoring

## Problem Description
The original system violated several core principles of Object-Oriented Programming, specifically the **Single Responsibility Principle (SRP)** and the **Interface Segregation Principle (ISP)**. 

The primary issue was a "Fat Interface." The `Order` interface forced implementing classes (like `OrderAction`) to handle multiple, unrelated responsibilities:
1. **Business Logic** (`calculateTotal`)
2. **Database/Persistence Operations** (`placeOrder`)
3. **File I/O Operations** (`generateInvoice`)
4. **Networking/External Communications** (`sendEmailNotification`)

Because these responsibilities were bundled together, modifying the invoice generation logic or changing the notification method would risk breaking the entire order placement system. Furthermore, any class implementing the `Order` interface was forced to provide concrete implementations for methods it might not even need.

To fix this, the code was refactored by creating a data-only `Order` class and breaking the operations into distinct, segregated interfaces (`OrderCalculator`, `OrderPlacement`, `InvoiceGenerator`, `NotificationService`). An `OrderProcessor` class was then introduced to orchestrate these dependencies using the **Dependency Inversion Principle (DIP)**.

### The Original Problem Code
```java
public interface Order {
  void calculateTotal(double price, int quantity);
  void placeOrder(String customerName, String address);
  void generateInvoice(String fileName);
  void sendEmailNotification(String email);
}

public class OrderAction implements Order {
  @Override
  public void calculateTotal(double price, int quantity) {
    double total = price * quantity;
    System.out.println("Order total: $" + total);
  }

  @Override
  public void placeOrder(String customerName, String address) {
    // Simulate placing order in a system
    System.out.println("Order placed for " + customerName + " at " + address);
  }

  @Override
  public void generateInvoice(String fileName) {
    // Simulate generating invoice file
    System.out.println("Invoice generated: " + fileName);
  }

  @Override
  public void sendEmailNotification(String email) {
    // Simulate sending email notification
    System.out.println("Email notification sent to: " + email);
  }
}

public class OrderTest {
  public static void main(String[] args) {
    Order order = new OrderAction();
    order.calculateTotal(10.0, 2);
    order.placeOrder("John Doe", "123 Main St");

    // These methods might not be needed for all orders
    order.generateInvoice("order_123.pdf");
    order.sendEmailNotification("johndoe@example.com");
  }
}
```

## UML Class Diagram Solution

The following UML diagram illustrates the refactored, SOLID-compliant structure of the system:

<img width="710" height="834" alt="SOLID PRINCIPLE" src="https://github.com/user-attachments/assets/98fd440d-a88c-4540-bf24-8f19ffdcaa14" />
