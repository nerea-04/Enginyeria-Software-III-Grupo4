package domain.order;

import domain.payment.Payment;
import domain.store.Store;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long orderId;
    private OrderState state;
    private List<Product> products;


    public Order() {
        this.orderId = Store.getInstance().nextAvailableOrderNumber();
        this.state = new PendingOrder();
        this.products = new ArrayList<>();
    }

    public long getId() {
        return orderId;
    }

    public String getStateName() {
        return state.getStateName();
    }

    public void setState(OrderState newState) {
        this.state = newState;
    }

    public void confirmOrderAndPay(Payment payment) {
        state.confirmOrderAndPay(this, payment);
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void deleteProduct(Product p) {
        products.remove(p);
    }

    public List<String> getProductNames() {
        return products.stream().map(Product::getName).toList();
    }

    public double calculateTotalProducts() {
        return products.stream().mapToDouble(Product::getFinalPrice).sum();
    }

    public double getTotal() {
        return calculateTotalProducts();
    }

    public double getTotalWithoutDiscount() {
        return products.stream().mapToDouble(Product::getStandardPrice).sum();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Object getPaymentStartDate() {
        return null;
    }

    public Object getPaymentEndDate() {
        return null;
    }
}
