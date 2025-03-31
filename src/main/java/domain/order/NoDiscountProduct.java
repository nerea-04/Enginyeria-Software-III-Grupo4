package domain.order;

public class NoDiscountProduct extends Product implements DiscountProduct {
    public NoDiscountProduct(String name, double standardPrice, String category) {
        super(name, standardPrice, category);
    }
}
