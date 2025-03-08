package bai1;

public class NewOrderState implements OrderState {
    @Override
    public void processOrder(OrderContext context) {
        System.out.println("Đang kiểm tra thông tin đơn hàng...");
        System.out.println("Thông tin đơn hàng hợp lệ.");

        // Chuyển sang trạng thái Đang xử lý
        context.setState(new ProcessingOrderState());
        System.out.println("Đơn hàng đã chuyển sang trạng thái: " + context.getState().getStateName());
    }

    @Override
    public String getStateName() {
        return "Mới tạo";
    }
}