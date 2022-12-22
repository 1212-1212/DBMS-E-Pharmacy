package mk.finki.ukim.epharmacy.repository.views;

import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.primaryKeys.BillsAndOrdersViewKey;
import mk.finki.ukim.epharmacy.model.views.BillsAndOrdersView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface BillsAndOrdersViewRepository extends JpaRepository<BillsAndOrdersView, BillsAndOrdersViewKey> {

    List<BillsAndOrdersView> findBillsAndOrdersViewByQuantityBetween(Long low, Long high);
    List<BillsAndOrdersView> findBillsAndOrdersViewByPriceBetween(Double low, Double high);
    List<BillsAndOrdersView> findBillsAndOrdersViewByGenericDrugNameIgnoreCase(String genericName);
    List<BillsAndOrdersView> findBillsAndOrdersViewByBrandedDrugNameContainingIgnoreCase(String brandedName);

    List<BillsAndOrdersView>findBillsAndOrdersViewByLocationNameContainingIgnoreCase(String LocationName);

    List<BillsAndOrdersView> findBillsAndOrdersViewByLocalDateTimeBetween(LocalDateTime from, LocalDateTime to);

    List<BillsAndOrdersView> findBillsAndOrdersViewByGenericDrugNameIn(List<String> generics);

    List<BillsAndOrdersView> findBillsAndOrdersViewByOrderStatus(ORDER_STATUS orderStatus);

    List<BillsAndOrdersView> findBillsAndOrdersViewByPaymentStatus(Boolean isPaid);


}
