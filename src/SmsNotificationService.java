public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(String recipient) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Phone number must not be blank.");
        }
        System.out.println("SMS notification sent to: " + recipient);
    }
}
