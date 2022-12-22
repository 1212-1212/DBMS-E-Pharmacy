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
    @JoinColumn(name = "pharmacy_id", referencedColumnName = "pharmacy_id")
    private Pharmacy pharmacy;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)

    private Patient patient;

    @Column(name = "payment_status")
    private boolean paymentStatus;

    public Bill(LocalDateTime dateTime, Pharmacy pharmacy, Patient patient, boolean paymentStatus) {
        this.dateTime = dateTime;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.paymentStatus = paymentStatus;
    }

    public Bill(Long billId, LocalDateTime dateTime, Patient patient, boolean paymentStatus) {
        this.billId = billId;
        this.dateTime = dateTime;
        this.patient = patient;
        this.paymentStatus=paymentStatus;
    }


    public Bill(LocalDateTime dateTime, Patient patient, boolean paymentStatus) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.paymentStatus = paymentStatus;
    }

    public Bill() {
    }
}
