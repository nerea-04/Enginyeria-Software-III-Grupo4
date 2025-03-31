package domain.store;

// implements Singleton Pattern
public class Store {

    private static Store instance;
    String name;
    String address;
    long totalOrders;

    private Store() {
        this.name = "Store";
        this.address = "Address";
        this.totalOrders = 0;
    }

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public int nextAvailableOrderNumber() {
        return (int) totalOrders + 1;
    }

    public String getName() { if (instance != null) return this.name; return "";}
    public String getAddress() {if (instance != null) return this.address; return "";}
    public long getTotalOrders() {if (instance != null) return this.totalOrders; return -1;}
}
