package mk.finki.ukim.epharmacy.service;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;
import mk.finki.ukim.epharmacy.model.views.PrescriptionView;

import java.util.List;

public interface BrandedDrugsAvailabilityViewService {

    List<BrandedDrugsAvailabilityView> findAll();
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(Integer quantity);
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(Float low, Float high);


    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByGenericName(String genericName);

    List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndText(Integer quantity, Float low, Float high, String text, String genericName);
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityBySearchText(String text);

}
