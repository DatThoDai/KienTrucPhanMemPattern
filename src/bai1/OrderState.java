package bai1;

public interface OrderState {
    void processOrder(OrderContext context);
    String getStateName();
}