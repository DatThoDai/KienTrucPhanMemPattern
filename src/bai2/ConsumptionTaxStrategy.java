package bai2;

public class ConsumptionTaxStrategy implements TaxStrategy {
    private final double rate;

    public ConsumptionTaxStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateTax(double price) {
        return price * rate;
    }

    @Override
    public String getDescription() {
        return "Thuế tiêu thụ (" + (rate * 100) + "%)";
    }
}
