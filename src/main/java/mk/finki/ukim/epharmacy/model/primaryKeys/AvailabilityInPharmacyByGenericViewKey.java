package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class AvailabilityInPharmacyByGenericViewKey implements Serializable {



    private Long pharmacyId;
    private Long genericDrugId;


    public AvailabilityInPharmacyByGenericViewKey(Long pharmacyId, Long genericDrugId) {
        this.pharmacyId = pharmacyId;
        this.genericDrugId = genericDrugId;
    }

    public AvailabilityInPharmacyByGenericViewKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityInPharmacyByGenericViewKey that = (AvailabilityInPharmacyByGenericViewKey) o;
        return Objects.equals(pharmacyId, that.pharmacyId) && Objects.equals(genericDrugId, that.genericDrugId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pharmacyId, genericDrugId);
    }
}
