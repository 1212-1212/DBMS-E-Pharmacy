package mk.finki.ukim.epharmacy.model.views;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.PrescriptionViewKey;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Data
@Immutable
@Table(name = "list_prescriptions_for_patient")
public class PrescriptionView {

    @EmbeddedId
    private PrescriptionViewKey key;

    @Column(name = "user_name")
    private String firstName;

    @Column(name = "user_surname")
    private String lastName;

    @Column(name = "generic")
    private String genericName;

    @Column(name = "prescription_date")
    private LocalDate localDate;

    @Column(name = "prescription_dosage")
    private String dosage;


    @Column(name = "prescription_signature")
    private String signature;



    @Column(name = "marked_as_used")

    private boolean markedAsUsed;

    public PrescriptionView() {
    }
}
