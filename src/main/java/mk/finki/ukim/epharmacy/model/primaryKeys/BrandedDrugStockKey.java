package mk.finki.ukim.epharmacy.model.primaryKeys;




import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class BrandedDrugStockKey implements Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandedDrugStockKey that = (BrandedDrugStockKey) o;
        return brandedDrugKey.equals(that.brandedDrugKey) && pharmacyId.equals(that.pharmacyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandedDrugKey, pharmacyId);
    }

    private BrandedDrugKey brandedDrugKey;

    @Column(name = "pharmacy_id")
    private Long pharmacyId;

    public BrandedDrugStockKey(BrandedDrugKey brandedDrugKey, Long pharmacyId) {
        this.brandedDrugKey = brandedDrugKey;
        this.pharmacyId = pharmacyId;
    }

    public BrandedDrugStockKey() {
    }
}
