package mk.finki.ukim.epharmacy.service.interfaces.views;

import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.views.BillsAndOrdersView;

import java.time.LocalDateTime;
import java.util.List;

public interface BillsAndOrdersViewService {
    List<BillsAndOrdersView> findBillsAndOrdersViewByQuantityBetween(Long low, Long high);
    List<BillsAndOrdersView> findBillsAndOrdersViewByPriceBetween(Double low, Double high);
    List<BillsAndOrdersView> findBillsAndOrdersViewByGenericDrugNameIgnoreCase(String genericName);
    List<BillsAndOrdersView> findBillsAndOrdersViewByBrandedDrugNameContainingIgnoreCase(String brandedName);


    List<BillsAndOrdersView> findBillsAndOrdersViewByLocalDateTimeBetween(LocalDateTime from, LocalDateTime to);

    List<BillsAndOrdersView> findBillsAndOrdersByQuantityRangeOrPriceRangeOrTimestampRangeOrGenericDrugNameOrBrandedDrugNameOrPharmacyNameOrOrderStatusOrPaymentStatus(
            Long quantityLow, Long quantityHigh, Double priceLow, Double priceHigh, LocalDateTime from, LocalDateTime to ,List<String> genericName, String brandedName, String pharmacyName, ORDER_STATUS orderStatus, Boolean isPaid);

    List<BillsAndOrdersView> findAll();

    List<BillsAndOrdersView>findBillsAndOrdersViewByLocationNameContainingIgnoreCase(String LocationName);

    List<BillsAndOrdersView> findBillsAndOrdersViewByGenericDrugNameIn(List<String> generics);

    List<BillsAndOrdersView> findBillsAndOrdersViewByOrderStatus(ORDER_STATUS orderStatus);

    List<BillsAndOrdersView> findBillsAndOrdersViewByPaymentStatus(Boolean isPaid);




}
