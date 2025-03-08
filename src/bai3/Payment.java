package bai3;

public interface Payment {
    void processPayment(double amount);
    double calculateTotal(double amount);
    String getDescription();
}
