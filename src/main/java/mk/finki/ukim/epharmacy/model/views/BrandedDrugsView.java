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

    @EmbeddedId
    private BrandedDrugKey key;

    @Column(name = "branded_drug_name")
    private String brandedDrugName;

    @Column(name = "generic")
    private String genericName;

    public BrandedDrugsView() {
    }
}
