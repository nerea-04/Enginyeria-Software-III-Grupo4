package domain.order;

public interface OrderState {
    void confirmOrder(Order order);
    String getStateName();
}
