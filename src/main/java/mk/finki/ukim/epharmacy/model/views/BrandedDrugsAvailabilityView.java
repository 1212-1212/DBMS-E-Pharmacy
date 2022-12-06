package mk.finki.ukim.epharmacy.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugsAvailabilityKey;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "available_branded_drugs_by_pharmacy_name")
@Data
public class BrandedDrugsAvailabilityView {

    @EmbeddedId
    private BrandedDrugsAvailabilityKey key;
    @Column(name = "price")
    private float price;
    @Column(name = "quantity")
    private int quantity;

    public BrandedDrugsAvailabilityView() {
    }
}
