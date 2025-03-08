package bai3;

public class SMSNotificationDecorator extends PaymentDecorator {
    private String phoneNumber;
    private double notificationFee;

    public SMSNotificationDecorator(Payment payment, String phoneNumber, double notificationFee) {
        super(payment);
        this.phoneNumber = phoneNumber;
        this.notificationFee = notificationFee;
    }

    @Override
    public void processPayment(double amount) {
        wrappedPayment.processPayment(amount);
        System.out.println("Gửi SMS xác nhận thanh toán đến số " + phoneNumber +
                ", phí SMS: " + notificationFee + " đồng");
    }

    @Override
    public double calculateTotal(double amount) {
        return wrappedPayment.calculateTotal(amount) + notificationFee;
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + ", thông báo SMS (+" + notificationFee + " đồng)";
    }
}
