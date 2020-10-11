package sample.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByOrderId(int orderId);
}
