package sample.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer", schema = "sample")
public class Customer {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "customer_id_seq")
    @SequenceGenerator(allocationSize = 1,sequenceName = "sample.sqc_customer_id", name = "customer_id_seq")
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

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

    @Override
    public String toString(){
        String st = "Customer{ customerId : "+customerId+",\n"+"name : "+name+",\n"+"dateOfBirth : "+dateOfBirth+"}";
        return st;
    }
}
