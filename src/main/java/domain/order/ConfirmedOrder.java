package domain.order;

import domain.payment.Payment;

import java.util.Date;

public class ConfirmedOrder implements OrderState{

    private double totalOrder;
    private Date confirmationDate;

    public ConfirmedOrder(Payment payment){

    }

    @Override
    public void confirmOrder(Order order) {

    }

    @Override
    public String getStateName() {
        return null;
    }
}
