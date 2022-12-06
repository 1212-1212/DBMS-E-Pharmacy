package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BilledDrugsKey;



@Data
@Entity
@Table(name = "branded_drug_bought_in_bill")
public class BilledDrugs {

    @EmbeddedId
    private BilledDrugsKey billedDrugsKey;

    private Float price;

    private Integer quantity;

    @ManyToOne
    @MapsId("billId")
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id", nullable = false)
    private Bill bill;

    @ManyToOne
    @MapsId("brandedDrugKey")
    @JoinColumns({
            @JoinColumn(name = "branded_drug_id", referencedColumnName = "branded_drug_id", nullable = false),
            @JoinColumn(name = "manufacturer_name", referencedColumnName = "manufacturer_name",nullable = false),
            @JoinColumn(name = "generic_drug_id", referencedColumnName = "generic_drug_id", nullable = false)
    })
    private BrandedDrug brandedDrug;

    public BilledDrugs(BilledDrugsKey billedDrugsKey, Float price, Integer quantity) {
        this.billedDrugsKey = billedDrugsKey;
        this.price = price;
        this.quantity = quantity;
    }



    public BilledDrugs(Float price, Integer quantity, Bill bill, BrandedDrug brandedDrug) {
        this.price = price;
        this.quantity = quantity;
        this.bill = bill;
        this.brandedDrug = brandedDrug;
    }

    public BilledDrugs() {
    }
}
