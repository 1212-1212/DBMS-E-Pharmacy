package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Table(name = "\"order\"")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime dateTime;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private Patient patient;

    public Order(LocalDateTime dateTime, Patient patient) {
        this.dateTime = dateTime;
        this.patient = patient;
    }

    public Order() {
    }
}
