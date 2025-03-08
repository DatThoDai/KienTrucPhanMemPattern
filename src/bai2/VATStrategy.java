package bai2;

public class VATStrategy implements TaxStrategy {
    private final double rate;

    public VATStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateTax(double price) {
        return price * rate;
    }

    @Override
    public String getDescription() {
        return "Thuế VAT (" + (rate * 100) + "%)";
    }
}