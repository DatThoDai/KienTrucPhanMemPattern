package bai2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public double calculateTotalTax() {
        double totalTax = 0;
        for (Product product : products) {
            totalTax += product.calculateTax();
        }
        return totalTax;
    }

    public double calculateFinalTotal() {
        return calculateTotalPrice() + calculateTotalTax();
    }

    public void printReceipt() {
        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("--------------------------------");
        System.out.printf("%-20s %-10s %-20s %-10s %-10s\n", "Sản phẩm", "Giá gốc", "Loại thuế", "Thuế", "Tổng cộng");
        System.out.println("--------------------------------");

        for (Product product : products) {
            System.out.printf("%-20s %-10.2f %-20s %-10.2f %-10.2f\n",
                    product.getName(),
                    product.getPrice(),
                    product.getTaxInfo(),
                    product.calculateTax(),
                    product.getFinalPrice());
        }

        System.out.println("--------------------------------");
        System.out.printf("Tổng tiền hàng: %.2f\n", calculateTotalPrice());
        System.out.printf("Tổng thuế: %.2f\n", calculateTotalTax());
        System.out.printf("Tổng thanh toán: %.2f\n", calculateFinalTotal());
        System.out.println("================================");
    }
}
