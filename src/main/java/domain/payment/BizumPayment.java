package domain.payment;

import java.sql.SQLOutput;

public class BizumPayment extends Payment{
    @Override
    protected void obtainPaymentData() {
        System.out.println("Customer Information Received");
    }

    @Override
    protected void validateData() {
        System.out.println("Validated customer data successfully");
    }

    @Override
    protected boolean executePayment() {
        System.out.println("Bizum payment received");
        return true;
    }

    @Override
    protected void sendReceipt() {
        System.out.println("Receipt sent to customer");
    }
}
