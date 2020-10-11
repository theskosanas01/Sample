package sample.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_order", schema = "sample")
public class CustomerOrder {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "customer_order_id_seq")
    @SequenceGenerator(allocationSize = 1,sequenceName = "sample.sqc_customer_order_id", name = "customer_order_id_seq")
    private int customerOrderId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "order_id", nullable = false)
    private int orderId;

    public int getCustomerOrderId(){
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    @Override
    public String toString(){
        String st = "CustomerOrder{ customerOrderId : "+customerOrderId+",\n"+"customerId : "+customerId+",\n"+"orderId : "+orderId+"}";
        return st;
    }
}
