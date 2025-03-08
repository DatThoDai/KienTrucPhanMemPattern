package bai2;

public interface TaxStrategy {
    double calculateTax(double price);
    String getDescription();
}
