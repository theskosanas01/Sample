package sample.entity;

import javax.persistence.*;

@Entity
@Table(name = "order", schema = "sample")
public class Order {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "order_id_seq")
    @SequenceGenerator(allocationSize = 1,sequenceName = "sample.sqc_order_id", name = "order_id_seq")
    private int orderId;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString(){
        String st = "Order{ orderId : "+orderId+",\n"+"amount : "+amount+",\n"+"deliveryAddress : "+deliveryAddress+"}";
        return st;
    }
}
