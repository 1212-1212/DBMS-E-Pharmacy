package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data

public class BilledDrugsKey implements Serializable {


    private BrandedDrugKey brandedDrugKey;
    @Column(name = "bill_id")
    private Long billId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BilledDrugsKey that = (BilledDrugsKey) o;
        return brandedDrugKey.equals(that.brandedDrugKey) && billId.equals(that.billId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandedDrugKey, billId);
    }

    public BilledDrugsKey(BrandedDrugKey brandedDrugKey, Long billId) {
        this.brandedDrugKey = brandedDrugKey;
        this.billId = billId;
    }

    public BilledDrugsKey() {
    }
}
