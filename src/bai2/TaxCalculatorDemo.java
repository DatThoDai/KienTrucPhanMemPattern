package bai2;

import bai2.Product;
import bai2.ShoppingCart;
import bai2.ConsumptionTaxStrategy;
import bai2.LuxuryTaxStrategy;
import bai2.VATStrategy;

public class TaxCalculatorDemo {
    public static void main(String[] args) {
        // Tạo các chiến lược tính thuế
        ConsumptionTaxStrategy consumptionTaxStrategy = new ConsumptionTaxStrategy(0.05); // 5% thuế tiêu thụ
        VATStrategy vatStrategy = new VATStrategy(0.10); // 10% VAT
        LuxuryTaxStrategy luxuryTaxStrategy = new LuxuryTaxStrategy(0.20, 1000); // 20% thuế xa xỉ cho sản phẩm > 1000

        // Tạo sản phẩm với các chiến lược thuế khác nhau
        Product rice = new Product("Gạo", 100, consumptionTaxStrategy);
        Product laptop = new Product("Laptop", 2000, vatStrategy);
        Product jewelry = new Product("Trang sức", 5000, luxuryTaxStrategy);

        // Tạo giỏ hàng và thêm sản phẩm
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(rice);
        cart.addProduct(laptop);
        cart.addProduct(jewelry);

        // In hóa đơn
        cart.printReceipt();

        // Thay đổi chiến lược thuế cho sản phẩm
        System.out.println("\nSau khi thay đổi thuế cho Laptop:");
        laptop.setTaxStrategy(luxuryTaxStrategy);
        cart.printReceipt();
    }
}
