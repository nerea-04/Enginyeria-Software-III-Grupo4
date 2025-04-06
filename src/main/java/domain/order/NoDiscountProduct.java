package domain.order;

public class NoDiscountProduct implements DiscountProduct {

    @Override
    public double applyDiscount(double standardPrice) {
        return standardPrice;
    }
}
