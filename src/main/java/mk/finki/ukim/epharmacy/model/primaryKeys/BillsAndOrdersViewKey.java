package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class BillsAndOrdersViewKey implements Serializable {


    private BrandedDrugKey brandedDrugKey;
    @Column(name = "bill_id")
    private Long billId;

    @Column(name = "user_id")
    private Long userId;

    public BillsAndOrdersViewKey(BrandedDrugKey brandedDrugKey, Long billId, Long userId) {
        this.brandedDrugKey = brandedDrugKey;
        this.billId = billId;
        this.userId = userId;
    }

    public BillsAndOrdersViewKey() {
    }
}
