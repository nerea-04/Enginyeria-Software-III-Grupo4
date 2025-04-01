package domain.payment;

import domain.order.ConfirmedOrder;

import java.time.LocalDate;

public abstract class Payment extends ConfirmedOrder {
    public LocalDate getStart() {
    }
}
