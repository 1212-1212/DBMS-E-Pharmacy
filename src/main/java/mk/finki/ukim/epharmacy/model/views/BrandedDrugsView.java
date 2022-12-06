package mk.finki.ukim.epharmacy.model.views;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "list_all_branded_drugs")
@Data
public class BrandedDrugsView {

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Id
    @Column(name = "branded_drug_name")
    private String brandedDrugName;

    @Column(name = "price")
    private float price;

    @Column(name = "generic")
    private String generic;

    public BrandedDrugsView() {
    }
}
