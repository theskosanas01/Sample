package sample.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(int customerId);

   // List<Customer> findAll();
}
