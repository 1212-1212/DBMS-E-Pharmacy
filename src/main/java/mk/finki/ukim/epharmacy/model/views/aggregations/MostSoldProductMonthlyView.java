package mk.finki.ukim.epharmacy.model.views.aggregations;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.MostSoldProductMonthlyViewKey;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

@Data
@Immutable
@Entity
@Table(name = "most_sold_drug_monthly_basis")
public class MostSoldProductMonthlyView implements Serializable {


    @EmbeddedId
    private MostSoldProductMonthlyViewKey key;

    @Column(name = "branded_drug_name")
    private String brandedDrugName;

    @Column(name = "generic_drug_name")
    private String genericDrugName;

    @Column(name = "total_sold")
    private Long totalSold;

    public MostSoldProductMonthlyView(MostSoldProductMonthlyViewKey key, String brandedDrugName, String genericDrugName, Long totalSold) {
        this.key = key;
        this.brandedDrugName = brandedDrugName;
        this.genericDrugName = genericDrugName;
        this.totalSold = totalSold;
    }

    public MostSoldProductMonthlyView() {
    }
}
