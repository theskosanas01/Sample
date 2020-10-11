package sample.dto;



public class OrderDTO {
    private int orderId;
    private double amount;
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

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString(){
        String st = "OrderDTO{ orderId : "+orderId+",\n"+"amount : "+amount+",\n"+"deliveryAddress : "+deliveryAddress+"}";
        return st;
    }
}
