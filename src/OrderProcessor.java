public class OrderProcessor {
    private final OrderCalculator    calculator;
    private final OrderPlacementService placementService;
    private final InvoiceService     invoiceService;
    private final NotificationService notificationService;

    public OrderProcessor(
            OrderCalculator calculator,
            OrderPlacementService placementService,
            InvoiceService invoiceService,
            NotificationService notificationService) {

        this.calculator          = calculator;
        this.placementService    = placementService;
        this.invoiceService      = invoiceService;
        this.notificationService = notificationService;
    }
    public double processOrder(
            double price,
            int    quantity,
            String customerName,
            String address,
            String invoiceFile,
            String recipient) {

        double total = calculator.calculateTotal(price, quantity);
        placementService.placeOrder(customerName, address);
        invoiceService.generateInvoice(invoiceFile);
        notificationService.sendNotification(recipient);
        return total;
    }
}
