package mk.finki.ukim.epharmacy.model.primaryKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class BrandedDrugsAvailabilityKey implements Serializable {


    @Column(name = "branded_drug_name")
    private String brandedDrugName;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Column(name = "generic")
    private String genericName;
    @Column(name ="pharmacy_name")
    private String pharmacyName;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "flat_number")
    private int flatNumber;

    public BrandedDrugsAvailabilityKey(String brandedDrugName, String manufacturerName, String genericName, String pharmacyName, String streetName, int flatNumber) {
        this.brandedDrugName = brandedDrugName;
        this.manufacturerName = manufacturerName;
        this.genericName = genericName;
        this.pharmacyName = pharmacyName;
        this.streetName = streetName;
        this.flatNumber = flatNumber;
    }

    public BrandedDrugsAvailabilityKey() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandedDrugsAvailabilityKey that = (BrandedDrugsAvailabilityKey) o;
        return flatNumber == that.flatNumber && brandedDrugName.equals(that.brandedDrugName) && manufacturerName.equals(that.manufacturerName) && genericName.equals(that.genericName) && pharmacyName.equals(that.pharmacyName) && streetName.equals(that.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandedDrugName, manufacturerName, genericName, pharmacyName, streetName, flatNumber);
    }
}
