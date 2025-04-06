package domain.order;

public class Product {

    private String name;
    private double standardPrice;
    private String category;

    private DiscountProduct discountProduct;

    public Product(String name, double standardPrice, String category) {
        this.name = name;
        this.standardPrice = standardPrice;
        this.category = category;
    }

    public Product(String name, double standardPrice, String category, DiscountProduct discountProduct) {
        this.name = name;
        this.standardPrice = standardPrice;
        this.category = category;
        this.discountProduct = discountProduct;
    }

    public double getFinalPrice() {
        return discountProduct.applyDiscount(standardPrice);
    }

    public String getName() {return name;}
    public double getStandardPrice() {return standardPrice;}
    public String getCategory() {return category;}
    public DiscountProduct getDiscountProduct() {
        return discountProduct;
    }
    public void setDiscountStrategy(DiscountProduct discountProduct) {
        this.discountProduct = discountProduct;
    }

    
    public void changeDiscount(DiscountProduct discountProduct){
        setDiscountStrategy(discountProduct);
    }

    public long getDiscountedPrice(){
        return -1;
    }


}
