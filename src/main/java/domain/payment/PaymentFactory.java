package domain.payment;

public class PaymentFactory {

    private static Payment p;

    public PaymentFactory(){
        p = null;
    }

    public static Payment selectPaymentMethod(PaymentMethod paymentMethod){
        switch (paymentMethod) {
            case CreditCard:
                p = new CreditCardPayment();
                break;
            case PayPal:
                p = new PayPalPayment();
                break;
            case Bizum:
                p = new BizumPayment();
                break;
            default:
                throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        }

        return p;
    }
}
