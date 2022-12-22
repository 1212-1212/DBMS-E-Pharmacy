package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;
import mk.finki.ukim.epharmacy.repository.tables.OrderShoppingCartRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.OrderShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderShoppingCartServiceImplementation implements OrderShoppingCartService {

    private final OrderShoppingCartRepository orderShoppingCartRepository;

    public OrderShoppingCartServiceImplementation(OrderShoppingCartRepository orderShoppingCartRepository) {
        this.orderShoppingCartRepository = orderShoppingCartRepository;
    }

    @Override
    public List<OrderShoppingCart> findAll() {
        return orderShoppingCartRepository.findAll();
    }

    @Override
    public OrderShoppingCart save(OrderShoppingCart orderShoppingCart) {
        return orderShoppingCartRepository.save(orderShoppingCart);
    }
}
