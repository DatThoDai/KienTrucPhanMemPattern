package bai1;

public class ProcessingOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Đang đóng gói đơn hàng...");
        System.out.println("Đang vận chuyển đơn hàng...");

        // Chuyển sang trạng thái Đã giao
        context.setState(new DeliveredOrderState());
        System.out.println("Đơn hàng đã chuyển sang trạng thái: " + context.getState().getStateName());
    }

    @Override
    public String getStateName() {
        return "Đang xử lý";
    }
}