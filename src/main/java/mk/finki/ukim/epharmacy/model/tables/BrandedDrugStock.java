package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;



@Data
@Entity
@Table(name = "in_stock")
public class BrandedDrugStock {

    @EmbeddedId
    private BrandedDrugStockKey brandedDrugStockKey;


    private float price;

    private int quantity;

    @ManyToOne
    @MapsId("brandedDrugKey")
    @JoinColumns({
            @JoinColumn(name = "branded_drug_id", referencedColumnName = "branded_drug_id", nullable = false),
            @JoinColumn(name = "manufacturer_name", referencedColumnName = "manufacturer_name",nullable = false),
            @JoinColumn(name = "generic_drug_id", referencedColumnName = "generic_drug_id", nullable = false)
    })
    private BrandedDrug brandedDrug;

    @ManyToOne
    @MapsId("pharmacyId")
    @JoinColumn(name = "pharmacy_id", referencedColumnName = "pharmacy_id", nullable = false)
    private Pharmacy pharmacy;

    public BrandedDrugStock(BrandedDrugStockKey brandedDrugStockKey, float price, int quantity) {
        this.brandedDrugStockKey = brandedDrugStockKey;
        this.price = price;
        this.quantity = quantity;

    }

    public BrandedDrugStock() {
    }

    public BrandedDrugStock(float price, int quantity, BrandedDrug brandedDrug, Pharmacy pharmacy) {
        this.price = price;
        this.quantity = quantity;
        this.brandedDrug = brandedDrug;
        this.pharmacy = pharmacy;
    }



}
