package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.tables.Order;
import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public interface OrderShoppingCartService {

    List<OrderShoppingCart> findAll();

    OrderShoppingCart save(OrderShoppingCart orderShoppingCart);

    Set<OrderShoppingCart> flatMapToSet(Stream<HashSet<OrderShoppingCart>> stream);
}
