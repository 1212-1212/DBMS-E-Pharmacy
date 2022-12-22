package mk.finki.ukim.epharmacy.service.interfaces.tables;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.epharmacy.model.tables.Order;

import java.util.Optional;

public interface OrderService {

    Order save(Order order);

    void initializeOrder(HttpServletRequest request);

    void checkoutOrder(HttpServletRequest request);
}
