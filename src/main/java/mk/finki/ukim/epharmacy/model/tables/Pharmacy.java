package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Table(name="pharmacy")
@Entity
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private Long pharmacyId;
    @Column(name = "pharmacy_name", nullable = false)
    private String pharmacyName;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "flat_number", nullable = false)
    private int flat_number;

    public Pharmacy(String pharmacyName, String streetName, int flat_number) {
        this.pharmacyName = pharmacyName;
        this.streetName = streetName;
        this.flat_number = flat_number;
    }

    public Pharmacy(Long pharmacyId, String pharmacyName, String streetName, int flat_number) {
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.streetName = streetName;
        this.flat_number = flat_number;
    }

    public Pharmacy() {
    }
}
