package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Table(name="generic_drug")
@Entity
public class GenericDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "generic_drug_id", nullable = false)
    private Long genericDrugId;
    @Column(name = "generic", nullable = false)
    private String generic;

    public GenericDrug(Long genericDrugId, String generic) {
        this.genericDrugId = genericDrugId;
        this.generic = generic;
    }


    public GenericDrug() {
    }
}


