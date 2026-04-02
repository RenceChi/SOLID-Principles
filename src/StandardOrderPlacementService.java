public class StandardOrderPlacementService implements OrderPlacementService {
    @Override
    public void placeOrder(String customerName, String address) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name must not be blank.");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address must not be blank.");
        }
        System.out.println("Order placed for " + customerName + " at " + address);
    }
}
