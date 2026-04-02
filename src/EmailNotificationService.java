public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String recipient) {
        if (recipient == null || !recipient.contains("@")) {
            throw new IllegalArgumentException("Invalid email address: " + recipient);
        }
        System.out.println("Email notification sent to: " + recipient);
    }
}
