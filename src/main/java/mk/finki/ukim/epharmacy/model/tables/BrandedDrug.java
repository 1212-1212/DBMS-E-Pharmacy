package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;


import java.time.LocalDateTime;

@Data
@Table(name = "branded_drug")
@Entity
public class BrandedDrug {
    @EmbeddedId
    private BrandedDrugKey brandedDrugKey;
    @Column(name = "branded_drug_name", nullable = false)
    private String brandedDrugName;
    @Column(name = "branded_drug_expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @ManyToOne
    @MapsId("genericDrugId")
    @JoinColumn(name = "generic_drug_id", referencedColumnName = "generic_drug_id", nullable = false)
    private GenericDrug genericDrug;


    public BrandedDrug(BrandedDrugKey brandedDrugKey, String brandedDrugName, LocalDateTime brandedDrugExpirationDate) {
        this.brandedDrugKey = brandedDrugKey;
        this.brandedDrugName = brandedDrugName;
        this.expirationDate = brandedDrugExpirationDate;
    }

    public BrandedDrug(BrandedDrugKey brandedDrugKey, String brandedDrugName, LocalDateTime expirationDate, GenericDrug genericDrug) {
        this.brandedDrugKey = brandedDrugKey;
        this.brandedDrugName = brandedDrugName;
        this.expirationDate = expirationDate;
        this.genericDrug = genericDrug;
    }

    public BrandedDrug() {
    }
}
