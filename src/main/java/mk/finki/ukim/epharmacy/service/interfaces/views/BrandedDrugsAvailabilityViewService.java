package mk.finki.ukim.epharmacy.service.interfaces.views;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;

import java.util.List;

public interface BrandedDrugsAvailabilityViewService {

    List<BrandedDrugsAvailabilityView> findAll();
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(Integer quantity);
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(Float low, Float high);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPharmacyNameContainingIgnoreCase(String pharmacyName);



    List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndTextAndPharmacyName(Integer quantity, Float low, Float high, String brandedName, String genericName, String pharmacyName);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByBrandedDrugNameContainingIgnoreCase(String brandedName);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByGenericName(String genericName);


}
