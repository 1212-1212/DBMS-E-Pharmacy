package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class BrandedDrugKey implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandedDrugKey that = (BrandedDrugKey) o;
        return brandedDrugId.equals(that.brandedDrugId) && manufacturerName.equals(that.manufacturerName) && genericDrugId.equals(that.genericDrugId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandedDrugId, manufacturerName, genericDrugId);
    }

    @Column(name = "branded_drug_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandedDrugId;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "generic_drug_id")
    private Long genericDrugId;


    public BrandedDrugKey(Long brandedDrugId, String manufacturerName, Long genericDrugId) {
        this.brandedDrugId = brandedDrugId;
        this.manufacturerName = manufacturerName;
        this.genericDrugId = genericDrugId;
    }

    public BrandedDrugKey(String manufacturerName, Long genericDrugId) {
        this.manufacturerName = manufacturerName;
        this.genericDrugId = genericDrugId;
    }

    public BrandedDrugKey() {
    }
}
