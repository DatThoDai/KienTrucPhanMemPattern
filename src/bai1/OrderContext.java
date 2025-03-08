package bai1;

public class OrderContext {
    private OrderState currentState;
    private String orderID;

    public OrderContext(String orderID) {
        this.orderID = orderID;
        // Trạng thái mặc định là Mới tạo
        this.currentState = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public OrderState getState() {
        return this.currentState;
    }

    public void processOrder() {
        System.out.println("\n----- Xử lý đơn hàng " + orderID + " (Trạng thái hiện tại: " + currentState.getStateName() + ") -----");
        this.currentState.processOrder(this);
    }

    public void cancelOrder() {
        System.out.println("\n----- Hủy đơn hàng " + orderID + " -----");
        this.setState(new CancelledOrderState());
        this.currentState.processOrder(this);
    }

    public String getOrderID() {
        return orderID;
    }
}