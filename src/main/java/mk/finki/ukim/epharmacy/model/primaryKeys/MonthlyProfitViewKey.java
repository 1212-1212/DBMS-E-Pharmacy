package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class MonthlyProfitViewKey implements Serializable {

    private Integer month;
    private Long pharmacyId;

    public MonthlyProfitViewKey(Integer month, Long pharmacyId) {
        this.month = month;
        this.pharmacyId = pharmacyId;
    }

    public MonthlyProfitViewKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthlyProfitViewKey that = (MonthlyProfitViewKey) o;
        return Objects.equals(month, that.month) && Objects.equals(pharmacyId, that.pharmacyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, pharmacyId);
    }
}
