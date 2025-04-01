package domain.order;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    private long orderId;
    private OrderState state;
    private List<Product> products;


    public Order(long orderId, String state) {
        this.orderId = orderId;
        this.state = new PendingOrder();
        this.products = new ArrayList<>();
    }
    public long getOrderId() {
        return orderId;
    }

    public String getStateName() {
        return state.getStateName();
    }
    public void confirmOrder(){
        state.confirmOrder(this);
    }
    public void setState(OrderState state) {
        this.state = state;
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void deleteProduct(Product product){
        products.remove(product);
    }
    public List<String> getProductName() {
        return products.stream().map(Product::getName).toList();
    }
    public double calculateTolalProducts(){
        return products.stream().mapToDouble(Product::getStandardPrice).sum();
    }
    public List<Product> getProducts() {
        return products;
    }
}
