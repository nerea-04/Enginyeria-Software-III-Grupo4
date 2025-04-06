package domain.order;

public class PercentageDiscountProduct implements DiscountProduct{

    private int discountPercentage;

    public PercentageDiscountProduct(int percentage) {
        try {
            confirmPercentage(percentage);
            this.discountPercentage = percentage;
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid percentage value: " + e.getMessage());
        }
    }

    @Override
    public double applyDiscount(double standardPrice) {
        return standardPrice * (1 - discountPercentage / 100.0);
    }

    private void confirmPercentage(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
    }

}
