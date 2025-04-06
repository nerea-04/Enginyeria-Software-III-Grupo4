package presentation;

import domain.order.*;

import domain.payment.BizumPayment;
import domain.payment.Payment;

import domain.payment.PaymentMethod;
import domain.store.Store;

import java.util.LinkedList;
import java.util.List;

public class StartSimulation {

    public static void main (String [] args) {

        Store store = Store.getInstance(); //TODO: Create new store

        System.out.println("Welcome to " + store.getName() + " at " + store.getAddress());
        System.out.println("*******************");


        List<Product> productList = addProducts();

        show(productList);
        Order o = createOrder(productList);
        System.out.println("Pending order info:");
        System.out.println("--------");
        showOrder(o);
        System.out.println("-----------------------------------------");
        System.out.println("Order payment:");
        System.out.println("--------");
        //TODO: You can use these lines below to create different payment methods
        PaymentMethod paymentCreditCard = PaymentMethod.CreditCard;
        PaymentMethod paymentBizum = PaymentMethod.Bizum;
        PaymentMethod paymentPaypal = PaymentMethod.PayPal;


        //TODO: Complete to create Payment
        Payment pay = new BizumPayment();

        o.confirmOrderAndPay(pay);
        System.out.println("Completed order info:");
        System.out.println("--------");
        showCompletedOrder(o);
        System.out.println("-----------------------------------------");
    }



    private static List<Product> addProducts() {
        List<Product> prodList = new LinkedList<>();

        /*TODO: Create 10 different products with different discount types and add them to prodList*/
        DiscountProduct discountPercentage1 = new PercentageDiscountProduct(10);
        DiscountProduct discountPercentage2 = new PercentageDiscountProduct(20);
        DiscountProduct discountPercentage3 = new PercentageDiscountProduct(30);
        DiscountProduct discountFixed1 = new FixedDiscountProduct(5);
        DiscountProduct discountFixed2 = new FixedDiscountProduct(15);
        DiscountProduct discountFixed3 = new FixedDiscountProduct(25);
        DiscountProduct discountNoDiscount = new NoDiscountProduct();


        Product p1 = new Product("Towel", 100.0, "Hygiene", discountPercentage1);
        Product p2 = new Product("Paper", 100.0, "Hygiene", discountPercentage2);
        Product p3 = new Product("Soap", 100.0, "Hygiene", discountPercentage3);
        Product p4 = new Product("Potatoes", 100.0, "Food", discountFixed1);
        Product p5 = new Product("Shampoo", 100.0, "Hygiene", discountFixed2);
        Product p6 = new Product("Spanish Serrano Ham", 100.0, "Food", discountFixed3);
        Product p7 = new Product("Coffee", 100.0, "Food", discountNoDiscount);
        Product p8 = new Product("Milk", 100.0, "Food", discountNoDiscount);
        Product p9 = new Product("Cereal", 100.0, "Food", discountNoDiscount);
        Product p10 = new Product("Baguette", 100.0, "Food", discountNoDiscount);

        prodList.add(p1);
        prodList.add(p2);
        prodList.add(p3);
        prodList.add(p4);
        prodList.add(p5);
        prodList.add(p6);
        prodList.add(p7);
        prodList.add(p8);
        prodList.add(p9);
        prodList.add(p10);

        /*TODO: Change the discount type of one of those created products*/
        p1.changeDiscount(discountFixed1);

        return prodList;
    }

    private static void show(List<Product> prodList){
        //System.out.println();
        System.out.println("Our store offers the following products:");
        for(Product p: prodList){
            show(p);
        }
        System.out.println("-----------------------------------------");

    }

    private static void show(Product p){
        System.out.println("Name:" + p.getName());
        System.out.println("Category:" + p.getCategory());
        System.out.println("Price:" + p.getStandardPrice());
        if (p.getStandardPrice() != p.getFinalPrice()) {
            System.out.println("Discounted Price: " + p.getFinalPrice());
        }
        System.out.println("******");
    }

    private static Order createOrder(List<Product> prodList) {
        /*TODO: Create a new pending order and add three different products from prodList*/
        Order o = new Order();
        o.addProduct(prodList.get(0));
        o.addProduct(prodList.get(4));
        o.addProduct(prodList.get(9));
        //TODO: Complete
        return o;
    }

    private static void showOrder(Order o) {
        System.out.println("Order ID: #" + o.getId());
        System.out.println("Total price w/discount: " + o.getTotal());
        System.out.println("Total price w/o discount: " + o.getTotalWithoutDiscount());
    }

    private static void showCompletedOrder(Order o) {
        showOrder(o);
        System.out.println("Start date and time: " + o.getPaymentStartDate());
        System.out.println("End date and time: " + o.getPaymentEndDate());
        System.out.println("Congratulations for buying the following products: ");
        System.out.println(o.getProductNames());
    }
}
