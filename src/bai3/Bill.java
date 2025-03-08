package bai3;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<String> items = new ArrayList<>();
    private double subtotal = 0;
    private Payment paymentMethod;

    public void addItem(String itemName, double price) {
        items.add(itemName + " - " + price + " đồng");
        subtotal += price;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout() {
        if (paymentMethod == null) {
            System.out.println("Vui lòng chọn phương thức thanh toán!");
            return;
        }

        System.out.println("\n=== HÓA ĐƠN THANH TOÁN ===");
        System.out.println("Các mặt hàng:");
        for (String item : items) {
            System.out.println("- " + item);
        }
        System.out.println("-------------------------");
        System.out.println("Tổng tiền hàng: " + subtotal + " đồng");
        double finalAmount = paymentMethod.calculateTotal(subtotal);
        System.out.println("Phương thức thanh toán: " + paymentMethod.getDescription());
        System.out.println("Tổng thanh toán: " + finalAmount + " đồng");
        System.out.println("-------------------------");

        paymentMethod.processPayment(subtotal);
        System.out.println("=== THANH TOÁN HOÀN TẤT ===");
    }
}
