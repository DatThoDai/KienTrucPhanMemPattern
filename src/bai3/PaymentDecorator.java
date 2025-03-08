package bai3;

public abstract class PaymentDecorator implements Payment {
    protected Payment wrappedPayment;

    public PaymentDecorator(Payment payment) {
        this.wrappedPayment = payment;
    }

    @Override
    public void processPayment(double amount) {
        wrappedPayment.processPayment(amount);
    }

    @Override
    public double calculateTotal(double amount) {
        return wrappedPayment.calculateTotal(amount);
    }

    @Override
    public String getDescription() {
        return wrappedPayment.getDescription();
    }
}
