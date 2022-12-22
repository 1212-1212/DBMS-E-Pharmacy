package mk.finki.ukim.epharmacy.model.views.aggregations;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.AvailabilityInPharmacyByGenericViewKey;
import org.hibernate.annotations.Immutable;


@Entity
@Immutable
@Data
@Table(name = "list_availability_in_pharmacy_by_generic")
public class AvailabilityInPharmacyByGenericView {

    @EmbeddedId
    private AvailabilityInPharmacyByGenericViewKey key;

    @Column(name = "pharmacy_name")
    private String pharmacyName;

    @Column(name = "street_name")
    private String streetName;

    @Column(name ="flat_number")
    private Integer flatNumber;

    @Column(name = "generic")
    private String genericDrugName;

    @Column(name = "total_available")
    private Long totalAvailable;


    public AvailabilityInPharmacyByGenericView(AvailabilityInPharmacyByGenericViewKey key, String pharmacyName, String streetName, Integer flatNumber, String genericDrugName, Long totalAvailable) {
        this.key = key;
        this.pharmacyName = pharmacyName;
        this.streetName = streetName;
        this.flatNumber = flatNumber;
        this.genericDrugName = genericDrugName;
        this.totalAvailable = totalAvailable;
    }

    public AvailabilityInPharmacyByGenericView() {
    }
}
