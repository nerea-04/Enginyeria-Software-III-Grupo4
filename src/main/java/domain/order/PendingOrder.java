package domain.order;

public class PendingOrder implements OrderState{


    @Override
    public void confirmOrder(Order order) {
        order.setState(new ConfirmedOrder());
    }

    @Override
    public String getStateName() {
        return "Pendiente";
    }
}
