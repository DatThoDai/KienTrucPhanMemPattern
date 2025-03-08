package bai3;

public class DiscountCodeDecorator extends PaymentDecorator {
    private String discountCode;
    private double discountRate;

    public DiscountCodeDecorator(Payment payment, String discountCode, double discountRate) {
        super(payment);
        this.discountCode = discountCode;
        this.discountRate = discountRate;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Áp dụng mã giảm giá " + discountCode + ": -" +
                calculateDiscount(amount) + " đồng");
        wrappedPayment.processPayment(calculateTotal(amount));
    }

    @Override
    public double calculateTotal(double amount) {
        return wrappedPayment.calculateTotal(amount - calculateDiscount(amount));
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + ", giảm giá " +
                (discountRate * 100) + "% với mã " + discountCode;
    }

    private double calculateDiscount(double amount) {
        return amount * discountRate;
    }
}
