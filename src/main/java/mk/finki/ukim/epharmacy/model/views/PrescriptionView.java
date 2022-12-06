package mk.finki.ukim.epharmacy.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Data
@Immutable
@Table(name = "list_prescriptions_for_patient")
public class PrescriptionView {


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

    @Id
    @Column(name = "prescription_signature")
    private String signature;

    public PrescriptionView() {
    }
}
