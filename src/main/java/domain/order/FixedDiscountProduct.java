package domain.order;

public class FixedDiscountProduct extends Product implements DiscountProduct {

    private double discountValue;

    public FixedDiscountProduct(String name, double standardPrice, String category) {
        super(name, standardPrice, category);
    }
}
