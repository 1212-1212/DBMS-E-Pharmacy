package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Data
@Table(name = "prescription")
@Entity
public class Prescription {

    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prescription_date", nullable = false)
    private LocalDate date;

    @Column(name = "prescription_dosage", nullable = false)
    private String dosage;

    @Column(name = "prescription_signature", nullable = false)
    private String signature;


    @ManyToOne
    @JoinColumn(name = "generic_drug_id", referencedColumnName = "generic_drug_id", nullable = false)

    private GenericDrug genericDrug;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)

    private Patient patient;

    public Prescription(LocalDate date, String dosage, String signature, GenericDrug genericDrug, Patient patient) {
        this.date = date;
        this.dosage = dosage;
        this.signature = signature;
        this.genericDrug = genericDrug;
        this.patient = patient;
    }

    public Prescription() {
    }
}
