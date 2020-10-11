package sample.dto;


import java.util.List;
import java.util.Date;

public class CustomerDTO {
    private int customerId;
    private String name;
    private Date dateOfBirth;

    private List<OrderDTO> orderDTOList;



    public int getCustomerId(){
        return customerId;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<OrderDTO> getOrderDTOList() {
        return orderDTOList;
    }

    public void setOrderDTOList(List<OrderDTO> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    @Override
    public String toString(){
        String st = "Customer{ customerId : "+customerId+",\n"+"name : "+name+",\ndateOfBirth : "+dateOfBirth+"}";
        return st;
    }
}
