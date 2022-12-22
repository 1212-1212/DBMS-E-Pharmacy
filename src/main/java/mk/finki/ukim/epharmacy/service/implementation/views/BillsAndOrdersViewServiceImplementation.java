package mk.finki.ukim.epharmacy.service.implementation.views;

import mk.finki.ukim.epharmacy.model.enumerations.ORDER_STATUS;
import mk.finki.ukim.epharmacy.model.factory.OrderStatusFactory;
import mk.finki.ukim.epharmacy.model.views.BillsAndOrdersView;
import mk.finki.ukim.epharmacy.repository.views.BillsAndOrdersViewRepository;
import mk.finki.ukim.epharmacy.service.interfaces.views.BillsAndOrdersViewService;
import mk.finki.ukim.epharmacy.service.interfaces.tables.GenericDrugService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BillsAndOrdersViewServiceImplementation implements BillsAndOrdersViewService {

    private final BillsAndOrdersViewRepository billsAndOrdersViewRepository;
    private final GenericDrugService genericDrugService;

    public BillsAndOrdersViewServiceImplementation(BillsAndOrdersViewRepository billsAndOrdersViewRepository, GenericDrugService genericDrugService) {
        this.billsAndOrdersViewRepository = billsAndOrdersViewRepository;
        this.genericDrugService = genericDrugService;
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByQuantityBetween(Long low, Long high) {
        if(low == null)
            low = 0L;
        if(high == null)
            high = Long.MAX_VALUE;
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByQuantityBetween(low, high);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByPriceBetween(Double low, Double high) {

        if(low == null)
            low = 0.0;
        if(high == null)
            high = Double.MAX_VALUE;
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByPriceBetween(low, high);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByGenericDrugNameIgnoreCase(String genericName) {
        if(genericName == null || genericName.isBlank() || genericName.isEmpty())
            return findAll();
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByGenericDrugNameIgnoreCase(genericName);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByBrandedDrugNameContainingIgnoreCase(String brandedName) {
        if(brandedName == null || brandedName.isBlank() || brandedName.isEmpty())
            return findAll();
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByBrandedDrugNameContainingIgnoreCase(brandedName);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByLocationNameContainingIgnoreCase(String locationName) {
        if(locationName == null || locationName.isBlank() || locationName.isEmpty())
            return findAll();
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByLocationNameContainingIgnoreCase(locationName);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByLocalDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        if(from == null)
            from = LocalDateTime.now().minusYears(50);
        if(to == null)
            to = LocalDateTime.now().plusYears(50);

        return billsAndOrdersViewRepository.findBillsAndOrdersViewByLocalDateTimeBetween(from, to);
    }

    @Override
    public List<BillsAndOrdersView> findAll() {
        return billsAndOrdersViewRepository.findAll();
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByGenericDrugNameIn(List<String> generics) {
        if(generics == null || generics.isEmpty())
            return findAll();
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByGenericDrugNameIn(generics);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByOrderStatus(ORDER_STATUS orderStatus) {
        if(orderStatus == ORDER_STATUS.ALL || orderStatus == null)
            return findAll();
        else {
            return billsAndOrdersViewRepository.findBillsAndOrdersViewByOrderStatus(orderStatus);
        }
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersViewByPaymentStatus(Boolean isPaid) {
        if(isPaid == null)
            return findAll();
        return billsAndOrdersViewRepository.findBillsAndOrdersViewByPaymentStatus(isPaid);
    }

    @Override
    public List<BillsAndOrdersView> findBillsAndOrdersByQuantityRangeOrPriceRangeOrTimestampRangeOrGenericDrugNameOrBrandedDrugNameOrPharmacyNameOrOrderStatusOrPaymentStatus
            (Long quantityLow, Long quantityHigh, Double priceLow, Double priceHigh, LocalDateTime from, LocalDateTime to, List<String> genericNames, String brandedName, String locationName, ORDER_STATUS orderStatus, Boolean isPaid) {
        Set<BillsAndOrdersView> quantityRangeSet = new HashSet<>(findBillsAndOrdersViewByQuantityBetween(quantityLow, quantityHigh));
        Set<BillsAndOrdersView> priceRangeSet = new HashSet<>(findBillsAndOrdersViewByPriceBetween(priceLow, priceHigh));
        Set<BillsAndOrdersView> dateRangeSet = new HashSet<>(findBillsAndOrdersViewByLocalDateTimeBetween(from, to));
        Set<BillsAndOrdersView> genericDrugSearchSet = new HashSet<>(findBillsAndOrdersViewByGenericDrugNameIn(genericNames));
        Set<BillsAndOrdersView> brandedDrugSearchSet = new HashSet<>(findBillsAndOrdersViewByBrandedDrugNameContainingIgnoreCase(brandedName));
        Set<BillsAndOrdersView> pharmacyNameSearchSet = new HashSet<>(findBillsAndOrdersViewByLocationNameContainingIgnoreCase(locationName));
        Set<BillsAndOrdersView> orderStatusSearchSet = new HashSet<>(findBillsAndOrdersViewByOrderStatus(orderStatus));
        Set<BillsAndOrdersView> paymentStatusSearchSet = new HashSet<>(findBillsAndOrdersViewByPaymentStatus(isPaid));
        quantityRangeSet.retainAll(priceRangeSet);
        quantityRangeSet.retainAll(dateRangeSet);
        quantityRangeSet.retainAll(genericDrugSearchSet);
        quantityRangeSet.retainAll(brandedDrugSearchSet);
        quantityRangeSet.retainAll(pharmacyNameSearchSet);
        quantityRangeSet.retainAll(orderStatusSearchSet);
        quantityRangeSet.retainAll(paymentStatusSearchSet);
        return quantityRangeSet.stream().toList();

    }

}
