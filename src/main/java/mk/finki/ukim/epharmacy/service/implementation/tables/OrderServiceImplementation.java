package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.tables.Order;
import mk.finki.ukim.epharmacy.repository.tables.OrderRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
