package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Table(name = "bill")
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id", nullable = false)
    private Long billId;

    @Column(name = "date_billed", nullable = false)
    private LocalDateTime dateTime;


    @ManyToOne
    @JoinColumn(name = "pharmacy_id", referencedColumnName = "pharmacy_id" ,nullable = false)
    private Pharmacy pharmacy;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)

    private Patient patient;


    public Bill(LocalDateTime dateTime, Pharmacy pharmacy, Patient patient) {
        this.dateTime = dateTime;
        this.pharmacy = pharmacy;
        this.patient = patient;
    }

    public Bill() {
    }
}
