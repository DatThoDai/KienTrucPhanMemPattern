package bai1;

public class CancelledOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Hủy đơn hàng...");
        System.out.println("Hoàn tiền cho khách hàng...");
        System.out.println("Đơn hàng đã bị hủy và đã hoàn tiền.");

        // Ở đây đơn hàng đã hủy, không chuyển sang trạng thái khác
    }

    @Override
    public String getStateName() {
        return "Hủy";
    }
}