package dev.yonk.backend.services;

import dev.yonk.backend.models.Order;
import dev.yonk.backend.repositories.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {

    OrderRepository orderRepository;

    @Inject
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void insertOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public boolean updateOrder(Order order, long id) {
        Optional<Order> orderOp = orderRepository.getOrderById(id);
        if(orderOp.isPresent()){
            orderRepository.updateOrder(order);
            return true;
        } else {
            return false;
        }
    }

    public Optional<Order> findOrderById (long id){
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAllOrder (){
       return orderRepository.getAllOrder() ;
    }

    public boolean deleteOrder(long id) {
        Optional<Order> order = orderRepository.getOrderById(id);
        if(order.isPresent()){
            orderRepository.deleteOrder(order.get());
            return true;
        } else {
            return false;
        }
    }
}
