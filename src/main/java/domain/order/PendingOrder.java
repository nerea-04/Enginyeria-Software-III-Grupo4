package domain.order;

import domain.payment.Payment;

import java.time.LocalDate;

public class PendingOrder implements OrderState{


    @Override
    public void confirmOrderAndPay(Order order, Payment payment) {
        order.setState(new ConfirmedOrder(payment, order));

    }

    @Override
    public String getStateName() {
        return "Pending";
    }

    @Override
    public double getTotal() {
        return 0;
    }

    @Override
    public LocalDate getPaymentStartDate() {
        return null;
    }

    @Override
    public LocalDate getPaymentEndDate() {
        return null;
    }

    @Override
    public LocalDate getConfirmationDate() {
        return null;
    }
}
