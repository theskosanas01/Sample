package sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.datalayer.CustomerOrderRepository;
import sample.datalayer.CustomerRepository;
import sample.datalayer.OrderRepository;
import sample.dto.CustomerDTO;
import sample.dto.OrderDTO;
import sample.entity.Customer;
import sample.entity.CustomerOrder;
import sample.entity.Order;
import sample.service.OrderService;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerOrder createOrder(Order order, int customerId) {

        CustomerOrder customerOrder = new CustomerOrder();

        Customer customer = customerRepository.findByCustomerId(customerId);

        int saveId = orderRepository.save(order).getOrderId();
        customerOrder.setOrderId(saveId);
        customerOrder.setCustomerId(customerId);

        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public List<CustomerDTO> getAllCustomers(){

        List<CustomerDTO> customerDTOS = new ArrayList<>() ;

        List<Customer> customerList = getCustomers();
        customerDTOS = getCustomerDTOS(customerList);
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomer(int customerId){
        List<Customer> customerListTemp = new ArrayList<>();

        Customer customer = customerRepository.findByCustomerId(customerId);
        customerListTemp.add(customer);
        CustomerDTO customerDTO  = getCustomerDTOS(customerListTemp).get(0);
        return customerDTO;
    }

    private List<Customer> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    private List<CustomerDTO> getCustomerDTOS(List<Customer> customerList){
        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
        List<CustomerOrder> customerOrderList = new ArrayList<CustomerOrder>();

        for (Customer customer: customerList){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setDateOfBirth(customer.getDateOfBirth());
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());

            customerOrderList.addAll(customerOrderRepository.findAllByCustomerId(customer.getCustomerId()));
            List<OrderDTO> orderDTOS = new ArrayList<OrderDTO>();
            for (CustomerOrder customerOrder: customerOrderList){
                Order order =  orderRepository.findByOrderId(customerOrder.getOrderId());
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setAmount(order.getAmount());
                orderDTO.setOrderId(order.getOrderId());
                orderDTO.setDeliveryAddress(order.getDeliveryAddress());
                orderDTOS.add(orderDTO);
            }
            customerDTO.setOrderDTOList(orderDTOS);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
