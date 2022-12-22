package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;
import mk.finki.ukim.epharmacy.repository.tables.OrderShoppingCartRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.OrderShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Set<OrderShoppingCart> flatMapToSet(Stream<HashSet<OrderShoppingCart>> stream) {
        return stream.flatMap(Collection::stream).collect(Collectors.toSet());
    }
}
