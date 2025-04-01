package domain.order;

import domain.payment.Payment;

import java.time.LocalDate;

public class ConfirmedOrder implements OrderState{

    private double totalOrder;
    private LocalDate confirmationDate;
    //
    private Payment payment;

    public ConfirmedOrder(Payment payment, Order order){
        this.totalOrder = order.calculateTotalProducts();
        this.confirmationDate = LocalDate.now();
        //this.payment = payment;

    }
    public void pay() {
        payment.processPayment();
    }

    @Override
    public void confirmOrderAndPay(Order order, Payment payment) {
        order.setState(new ConfirmedOrder(payment, order));
    }

    @Override
    public String getStateName() {
        return "Confirmed";
    }

    @Override
    public double getTotal() {
        return totalOrder;
    }
    @Override
    public LocalDate getPaymentStartDate() {
        return payment.getStart();
    }

    @Override
    public LocalDate getPaymentEndDate() {
        return payment.getEnd();
    }

    @Override
    public LocalDate getConfirmationDate() {
        return confirmationDate;
    }
}
