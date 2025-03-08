package bai3;

public class PayPalPayment implements Payment {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Xử lý thanh toán " + amount + " đồng qua PayPal với email " + email);
    }

    @Override
    public double calculateTotal(double amount) {
        return amount;
    }

    @Override
    public String getDescription() {
        return "Thanh toán PayPal";
    }
}
