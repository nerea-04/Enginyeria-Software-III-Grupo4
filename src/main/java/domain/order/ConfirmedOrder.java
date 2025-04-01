package domain.order;

import domain.payment.Payment;

import java.util.Date;

public class ConfirmedOrder extends Order{

    private double totalOrder;
    private Date confirmationDate;

    public ConfirmedOrder(Payment payment){
        
    }
}
