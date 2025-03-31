package domain.order;

public class PercentageDiscountProduct extends Product implements DiscountProduct{

    private int discountPercentatge;

    public PercentageDiscountProduct(String name, double standardPrice, String category) {
        super(name, standardPrice, category);
    }
}
