package mk.finki.ukim.epharmacy.repository.tables;

import mk.finki.ukim.epharmacy.model.primaryKeys.OrderShoppingCartKey;
import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  OrderShoppingCartRepository extends JpaRepository<OrderShoppingCart, OrderShoppingCartKey> {


}
