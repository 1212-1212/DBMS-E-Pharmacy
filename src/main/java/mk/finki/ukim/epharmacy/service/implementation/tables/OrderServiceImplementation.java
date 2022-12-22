package mk.finki.ukim.epharmacy.service.implementation.tables;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.tables.Bill;
import mk.finki.ukim.epharmacy.model.tables.Order;
import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;
import mk.finki.ukim.epharmacy.model.tables.Patient;
import mk.finki.ukim.epharmacy.repository.tables.BillRepository;
import mk.finki.ukim.epharmacy.repository.tables.OrderRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;


    public OrderServiceImplementation(OrderRepository orderRepository, BillRepository billRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }


    @Transactional
    @Override
    public void initializeOrder(HttpServletRequest request) {
        if (request.getSession().getAttribute("order") == null && request.getSession().getAttribute("bill") == null) {
            Patient user = (Patient) request.getSession().getAttribute("patient");
            if(Objects.isNull(user))
                throw new RuntimeException();
            Bill bill = new Bill(LocalDateTime.now(), user, false);
            Order order = new Order(LocalDateTime.now(), user, bill, ORDER_STATUS.CREATED);
            billRepository.save(bill);
            orderRepository.save(order);
            request.getSession().setAttribute("bill", bill);
            request.getSession().setAttribute("order", order);
            request.getSession().setAttribute("map", new HashMap<Long, HashSet<OrderShoppingCart>>());
        }

    }
    @Transactional
    @Override
    public void checkoutOrder(HttpServletRequest request) {
        Bill bill = (Bill) request.getSession().getAttribute("bill");
        bill.setDateTime(LocalDateTime.now());
        bill.setPaymentStatus(true);
        billRepository.save(bill);
        Order order = (Order) request.getSession().getAttribute("order");
        order.setDateTime(LocalDateTime.now());
        order.setOrderStatus(ORDER_STATUS.FINISHED);
        orderRepository.save(order);
    }
}
