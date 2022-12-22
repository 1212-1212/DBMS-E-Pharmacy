package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.OrderShoppingCartKey;



@Entity
@Data
@Table(name = "order_shopping_cart")
public class OrderShoppingCart {

    @EmbeddedId
    private OrderShoppingCartKey orderShoppingCartKey;

    @ManyToOne
    @MapsId("brandedDrugKey")
    @JoinColumns({
            @JoinColumn(name = "branded_drug_id", referencedColumnName = "branded_drug_id", nullable = false),
            @JoinColumn(name = "manufacturer_name", referencedColumnName = "manufacturer_name",nullable = false),
            @JoinColumn(name = "generic_drug_id", referencedColumnName = "generic_drug_id", nullable = false)
    })
    private BrandedDrug brandedDrug;
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)

    private Order order;

    private float price;

    private int quantity;



    public OrderShoppingCart(BrandedDrug brandedDrug, Order order, float price, int quantity) {
        this.brandedDrug = brandedDrug;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderShoppingCart(Order order) {
        this.order = order;
    }

    public OrderShoppingCart(OrderShoppingCartKey orderShoppingCartKey, BrandedDrug brandedDrug, Order order, float price, int quantity) {
        this.orderShoppingCartKey = orderShoppingCartKey;
        this.brandedDrug = brandedDrug;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderShoppingCart(OrderShoppingCartKey orderShoppingCartKey, float price, int quantity) {
        this.orderShoppingCartKey = orderShoppingCartKey;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderShoppingCart() {

    }
}
