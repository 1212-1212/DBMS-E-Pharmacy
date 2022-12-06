package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class BrandedDrugShoppingCartKey implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandedDrugShoppingCartKey that = (BrandedDrugShoppingCartKey) o;
        return brandedDrugKey.equals(that.brandedDrugKey) && orderId.equals(that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandedDrugKey, orderId);
    }

    private BrandedDrugKey brandedDrugKey;

    @Column(name = "order_id")
    private Long orderId;

    public BrandedDrugShoppingCartKey(BrandedDrugKey brandedDrugKey, Long orderId) {
        this.brandedDrugKey = brandedDrugKey;
        this.orderId = orderId;
    }

    public BrandedDrugShoppingCartKey() {
    }
}
