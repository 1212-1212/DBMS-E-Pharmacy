package mk.finki.ukim.epharmacy.model.tables;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;


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

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id", nullable = false)
    private Bill bill;

    @Column(name = "order_status")
    @Enumerated(value = EnumType.STRING)
    private ORDER_STATUS orderStatus;

    public Order(LocalDateTime dateTime, Patient patient, Bill bill, ORDER_STATUS orderStatus) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.bill = bill;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }
}
