package domain.order;

public class FixedDiscountProduct implements DiscountProduct {

    private final double discountValue;

    public FixedDiscountProduct(double discountValue) {
        this.discountValue = discountValue;
    }

    @Override
    public double applyDiscount(double standardPrice) {
        return Math.max(0, standardPrice - discountValue);
    }
}
