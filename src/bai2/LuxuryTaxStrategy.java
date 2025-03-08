package bai2;

public class LuxuryTaxStrategy implements TaxStrategy {
    private final double rate;
    private final double threshold;

    public LuxuryTaxStrategy(double rate, double threshold) {
        this.rate = rate;
        this.threshold = threshold;
    }

    @Override
    public double calculateTax(double price) {
        if (price > threshold) {
            return price * rate;
        } else {
            return 0;
        }
    }

    @Override
    public String getDescription() {
        return "Thuế xa xỉ (" + (rate * 100) + "%, áp dụng cho sản phẩm trên " + threshold + " đồng)";
    }
}