package bai3;

public class PaymentSystemDemo {
    public static void main(String[] args) {
        // Tạo hóa đơn
        Bill bill = new Bill();
        bill.addItem("Laptop", 15000000);
        bill.addItem("Chuột không dây", 500000);
        bill.addItem("Bàn phím cơ", 2000000);

        // Demo 1: Thanh toán cơ bản bằng thẻ tín dụng
        System.out.println("\nDemo 1: Thanh toán cơ bản bằng thẻ tín dụng");
        Payment creditCardPayment = new CreditCardPayment("1234567890123456", "123", "12/25");
        bill.setPaymentMethod(creditCardPayment);
        bill.checkout();

        // Demo 2: Thanh toán PayPal với phí xử lý
        System.out.println("\nDemo 2: Thanh toán PayPal với phí xử lý");
        Payment paypalWithFee = new ProcessingFeeDecorator(
                new PayPalPayment("user@example.com"), 0.02); // Phí 2%
        bill.setPaymentMethod(paypalWithFee);
        bill.checkout();

        // Demo 3: Thanh toán thẻ tín dụng với mã giảm giá
        System.out.println("\nDemo 3: Thanh toán thẻ tín dụng với mã giảm giá");
        Payment creditCardWithDiscount = new DiscountCodeDecorator(
                new CreditCardPayment("9876543210987654", "456", "10/26"),
                "SALE20", 0.2); // Giảm 20%
        bill.setPaymentMethod(creditCardWithDiscount);
        bill.checkout();

        // Demo 4: Thanh toán PayPal với phí xử lý, mã giảm giá, và thông báo SMS
        System.out.println("\nDemo 4: Thanh toán PayPal với nhiều decorator");
        Payment complexPayment = new SMSNotificationDecorator(
                new DiscountCodeDecorator(
                        new ProcessingFeeDecorator(
                                new PayPalPayment("customer@example.com"), 0.015), // Phí 1.5%
                        "WELCOME10", 0.1), // Giảm 10%
                "0987654321", 5000); // Phí SMS 5000 đồng
        bill.setPaymentMethod(complexPayment);
        bill.checkout();
    }
}
