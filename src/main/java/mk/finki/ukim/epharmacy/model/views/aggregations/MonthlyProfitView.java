package mk.finki.ukim.epharmacy.model.views.aggregations;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import mk.finki.ukim.epharmacy.model.primaryKeys.MonthlyProfitViewKey;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Data
@Table(name = "monthly_profit")
public class MonthlyProfitView {

    @EmbeddedId
    private MonthlyProfitViewKey key;

    @Column(name = "total_profit")
    private Double totalProfit;

    @Column(name = "pharmacy_name_or_online")
    private String pharmacyName;

    @Column(name = "street_name")
    private String streetName;
    @Column(name = "flat_number")
    private Integer flatNumber;
    @Column(name = "total_payments")
    private Long totalPayments;

    public MonthlyProfitView(MonthlyProfitViewKey key, Double totalProfit, String pharmacyName, String streetName, Integer flatNumber, Long totalPayments) {
        this.key = key;
        this.totalProfit = totalProfit;
        this.pharmacyName = pharmacyName;
        this.streetName = streetName;
        this.flatNumber = flatNumber;
        this.totalPayments = totalPayments;
    }

    public MonthlyProfitView() {

    }
}
