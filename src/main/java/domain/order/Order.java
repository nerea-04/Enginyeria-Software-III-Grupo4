package domain.order;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    private long orderId;
    private OrderState state;
    private List<Product> products;


    public Order(long orderId, String state) {
        this.orderId = orderId;
        this.state = new PendingOrder();
        this.products = new ArrayList<>();
    }
    public long getOrderId() {
        return orderId;
    }

    public String getStateName() {
        return state.getStateName();
    }
    public void con

}
