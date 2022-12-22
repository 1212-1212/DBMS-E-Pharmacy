package mk.finki.ukim.epharmacy.service.interfaces.views;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;

import java.util.List;

public interface BrandedDrugsAvailabilityViewService {

    List<BrandedDrugsAvailabilityView> findAll();
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(Integer quantity);
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(Float low, Float high);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPharmacyName(String pharmacyName);


    List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndText(Integer quantity, Float low, Float high, String text, String genericName);

    List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndTextAndPharmacyName(Integer quantity, Float low, Float high, String text, String genericName, String pharmacyName);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityBySearchText(String text);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByGenericName(String genericName);


}
