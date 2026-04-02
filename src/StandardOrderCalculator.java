public class StandardOrderCalculator implements OrderCalculator {
    @Override
    public double calculateTotal(double price, int quantity) {
        if (price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Price and quantity must be non-negative.");
        }
        double total = price * quantity;
        System.out.println("Order total: $" + total);
        return total;
    }
}
