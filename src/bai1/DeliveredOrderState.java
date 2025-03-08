package bai1;

public class DeliveredOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Cập nhật trạng thái đơn hàng là đã giao.");
        System.out.println("Đơn hàng đã hoàn thành!");

        // Ở đây đơn hàng đã hoàn thành, không chuyển sang trạng thái khác
    }

    @Override
    public String getStateName() {
        return "Đã giao";
    }
}