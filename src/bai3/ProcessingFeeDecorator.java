package bai3;

public class ProcessingFeeDecorator extends PaymentDecorator {
    private double feeRate;

    public ProcessingFeeDecorator(Payment payment, double feeRate) {
        super(payment);
        this.feeRate = feeRate;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Áp dụng phí xử lý: " + calculateFee(amount) + " đồng");
        wrappedPayment.processPayment(calculateTotal(amount));
    }

    @Override
    public double calculateTotal(double amount) {
        return wrappedPayment.calculateTotal(amount) + calculateFee(amount);
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription() + ", phí xử lý " + (feeRate * 100) + "%";
    }

    private double calculateFee(double amount) {
        return amount * feeRate;
    }
}