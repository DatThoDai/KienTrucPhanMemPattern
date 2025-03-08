package bai1;

public class OrderManagementDemo {
    public static void main(String[] args) {
        // Tạo đơn hàng mới
        OrderContext order1 = new OrderContext("ORD-001");

        // Xử lý đơn hàng qua các trạng thái
        order1.processOrder(); // Từ Mới tạo -> Đang xử lý
        order1.processOrder(); // Từ Đang xử lý -> Đã giao
        order1.processOrder(); // Đã giao (trạng thái cuối)

        System.out.println("\n------------------------------------------");

        // Tạo đơn hàng mới và hủy
        OrderContext order2 = new OrderContext("ORD-002");
        order2.processOrder(); // Từ Mới tạo -> Đang xử lý
        order2.cancelOrder();  // Hủy đơn hàng

        System.out.println("\n------------------------------------------");

        // Tạo đơn hàng mới và hủy ngay
        OrderContext order3 = new OrderContext("ORD-003");
        order3.cancelOrder();  // Hủy đơn hàng
    }
}