package bai3;

public class CreditCardPayment implements Payment {
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Xử lý thanh toán " + amount + " đồng qua thẻ tín dụng " +
                getMaskedCardNumber());
    }

    @Override
    public double calculateTotal(double amount) {
        return amount; // Thanh toán cơ bản không thêm chi phí
    }

    @Override
    public String getDescription() {
        return "Thanh toán thẻ tín dụng";
    }

    private String getMaskedCardNumber() {
        // Che giấu 12 số đầu, chỉ hiển thị 4 số cuối
        return "xxxx-xxxx-xxxx-" + cardNumber.substring(cardNumber.length() - 4);
    }
}

