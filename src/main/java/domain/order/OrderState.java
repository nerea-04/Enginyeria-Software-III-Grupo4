package domain.order;

import domain.payment.Payment;

import java.time.LocalDate;

public interface OrderState {
    void confirmOrderAndPay(Order order, Payment payment);
    String getStateName();
    double getTotal();

    LocalDate getPaymentStartDate();

    LocalDate getPaymentEndDate();

    LocalDate getConfirmationDate();
}
