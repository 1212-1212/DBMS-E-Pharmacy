package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugShoppingCartKey;



@Entity
@Data
@Table(name = "branded_drug_in_shopping_cart")
public class BrandedDrugShoppingCart {

    @EmbeddedId
    private BrandedDrugShoppingCartKey brandedDrugShoppingCartKey;

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



    public BrandedDrugShoppingCart(BrandedDrug brandedDrug, Order order, float price, int quantity) {
        this.brandedDrug = brandedDrug;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
    }

    public BrandedDrugShoppingCart(BrandedDrugShoppingCartKey brandedDrugShoppingCartKey, float price, int quantity) {
        this.brandedDrugShoppingCartKey = brandedDrugShoppingCartKey;
        this.price = price;
        this.quantity = quantity;
    }

    public BrandedDrugShoppingCart() {

    }
}
