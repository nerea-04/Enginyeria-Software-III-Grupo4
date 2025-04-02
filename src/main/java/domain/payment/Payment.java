package domain.payment;

import domain.order.ConfirmedOrder;

import java.time.LocalDate;

public abstract class Payment  { //extends ConfirmedOrder {
    private LocalDate start;
    private LocalDate end;

    public Payment(){
        this.start = LocalDate.now();
    }
    public void processPayment() {
        obtainPaymentData();
        validateData();
        executePayment();
        setEndDate();
        sendReceipt();
    }
    public LocalDate getStart() {
        return start;
    }
    public LocalDate getEnd() {
        return end;
    }
    protected void setEndDate() {
        this.end = LocalDate.now();
    }
    protected abstract void obtainPaymentData();
    protected abstract void validateData();
    protected abstract void executePayment();
    protected abstract void sendReceipt();
}
