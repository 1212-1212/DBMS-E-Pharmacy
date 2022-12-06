package mk.finki.ukim.epharmacy.repository;

import mk.finki.ukim.epharmacy.model.tables.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
