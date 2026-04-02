public class OrderTest {
    public static void main(String[] args) {

        //Order 1: email notification
        OrderProcessor emailOrder = new OrderProcessor(
                new StandardOrderCalculator(),
                new StandardOrderPlacementService(),
                new PdfInvoiceService(),
                new EmailNotificationService()
        );

        System.out.println("=== Order 1 (email) ===");
        emailOrder.processOrder(
                10.0, 2,
                "John Doe", "123 Main St",
                "order_123.pdf",
                "johndoe@example.com"
        );

        System.out.println();

        //Order 2: SMS notification
        OrderProcessor smsOrder = new OrderProcessor(
                new StandardOrderCalculator(),
                new StandardOrderPlacementService(),
                new PdfInvoiceService(),
                new SmsNotificationService()
        );

        System.out.println("=== Order 2 (SMS) ===");
        smsOrder.processOrder(
                25.0, 3,
                "Jane Smith", "456 Oak Ave",
                "order_456.pdf",
                "+63-919-432-1234"
        );
    }
}
