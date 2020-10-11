package sample.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {

    List<CustomerOrder> findAllByCustomerId(int customerId);

}
