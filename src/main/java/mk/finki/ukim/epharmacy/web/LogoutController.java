package mk.finki.ukim.epharmacy.web;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.tables.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        if(request.getSession().getAttribute("order") != null)
        {
            Order order = (Order) request.getAttribute("order");
            if(order.getOrderStatus() == ORDER_STATUS.CREATED)
                order.setOrderStatus(ORDER_STATUS.CANCELLED);
        }
        return "redirect:/login";
    }

}
