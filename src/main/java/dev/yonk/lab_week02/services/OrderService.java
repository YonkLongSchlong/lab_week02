package dev.yonk.lab_week02.services;

import dev.yonk.lab_week02.models.Order;
import dev.yonk.lab_week02.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void insertOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void updateOrder(Order order) {
        orderRepository.updateOrder(order);
    }

    public Optional<Order> findOrderById (long id){
        return orderRepository.getOrderById(id);
    }

    public List<Order> findOrderById (){
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
