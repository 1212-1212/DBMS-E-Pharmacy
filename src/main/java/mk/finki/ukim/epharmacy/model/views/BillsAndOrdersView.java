package mk.finki.ukim.epharmacy.model.views;

import jakarta.persistence.*;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;

import mk.finki.ukim.epharmacy.model.primaryKeys.BillsAndOrdersViewKey;
import org.hibernate.annotations.Immutable;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
@Immutable
@Data
@Table(name = "bills_and_orders")
public class BillsAndOrdersView {


    @EmbeddedId

    private BillsAndOrdersViewKey key;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "date_billed")
    private LocalDateTime localDateTime;

    @Column(name = "payment_status")
    private boolean paymentStatus;



    @Column(name = "branded_drug_name")
    private String brandedDrugName;

    @Column(name = "generic_drug_name")
    private String genericDrugName;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private ORDER_STATUS orderStatus;

    @Column(name = "pharmacy_name_or_online")
    private String locationName;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "flat_number")
    private Integer flatNumber;

    @Column(name = "user_name")
    private String userName;



    @Column(name = "user_surname")
    private String userSurname;

    public BillsAndOrdersView(BillsAndOrdersViewKey key, LocalDateTime localDateTime, String brandedDrugName, String genericDrugName, Double price, Long quantity, Long orderId, ORDER_STATUS orderStatus,String locationName, String streetName, Integer flatNumber, String userName, String userSurname) {
        this.key = key;
        this.localDateTime = localDateTime;
        this.brandedDrugName = brandedDrugName;
        this.genericDrugName = genericDrugName;
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.orderStatus=orderStatus;
        this.locationName = locationName;
        this.streetName = streetName;
        this.flatNumber = flatNumber;
        this.userName = userName;
        this.userSurname = userSurname;
    }

    public BillsAndOrdersView() {
    }
}
