package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.tables.Order;
import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;

import java.util.List;

public interface OrderShoppingCartService {

    List<OrderShoppingCart> findAll();

    OrderShoppingCart save(OrderShoppingCart orderShoppingCart);
}
