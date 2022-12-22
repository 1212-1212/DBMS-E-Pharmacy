package mk.finki.ukim.epharmacy.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "available_branded_drugs_by_pharmacy_name")
@Data
public class BrandedDrugsAvailabilityView {

    @EmbeddedId
    private BrandedDrugStockKey key;
    @Column(name = "branded_drug_name")
    private String brandedDrugName;
    @Column(name = "generic")
    private String genericName;
    @Column(name ="pharmacy_name")
    private String pharmacyName;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "flat_number")
    private int flatNumber;
    @Column(name = "price")
    private float price;
    @Column(name = "quantity")
    private int quantity;

    public BrandedDrugsAvailabilityView() {
    }
}
