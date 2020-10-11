package sample.service;

import sample.dto.CustomerDTO;
import sample.entity.CustomerOrder;
import sample.entity.Order;

import java.util.List;

public interface OrderService {

    CustomerOrder createOrder(Order order, int customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(int customerId);
}
