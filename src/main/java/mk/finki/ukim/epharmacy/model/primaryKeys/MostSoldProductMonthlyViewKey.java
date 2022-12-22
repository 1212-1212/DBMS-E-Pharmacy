package mk.finki.ukim.epharmacy.model.primaryKeys;


import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class MostSoldProductMonthlyViewKey implements Serializable {

    private Integer month;
    private Long brandedDrugId;
    private String manufacturerName;
    private String genericDrugId;

    public MostSoldProductMonthlyViewKey() {
    }

    public MostSoldProductMonthlyViewKey(Integer month, Long brandedDrugId, String manufacturerName, String genericDrugId) {
        this.month = month;
        this.brandedDrugId = brandedDrugId;
        this.manufacturerName = manufacturerName;
        this.genericDrugId = genericDrugId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MostSoldProductMonthlyViewKey that = (MostSoldProductMonthlyViewKey) o;
        return Objects.equals(month, that.month) && Objects.equals(brandedDrugId, that.brandedDrugId) && Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(genericDrugId, that.genericDrugId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, brandedDrugId, manufacturerName, genericDrugId);
    }
}
