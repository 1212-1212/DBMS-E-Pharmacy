package mk.finki.ukim.epharmacy.service.implementation.views;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;
import mk.finki.ukim.epharmacy.repository.views.BrandedDrugsAvailabilityRepository;
import mk.finki.ukim.epharmacy.service.interfaces.views.BrandedDrugsAvailabilityViewService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BrandedDrugsAvailabilityViewServiceImplementation implements BrandedDrugsAvailabilityViewService {

    private final BrandedDrugsAvailabilityRepository brandedDrugsAvailabilityRepository;

    public BrandedDrugsAvailabilityViewServiceImplementation(BrandedDrugsAvailabilityRepository brandedDrugsAvailabilityRepository) {
        this.brandedDrugsAvailabilityRepository = brandedDrugsAvailabilityRepository;
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findAll() {
        return brandedDrugsAvailabilityRepository.findAll();
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByGenericName(String genericName) {
        if(genericName == null || genericName.equals("All"))
            return findAll();
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByGenericName(genericName);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(Integer quantity) {
        if(quantity == null)
            return findAll();
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByQuantityGreaterThan(quantity);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(Float low, Float high) {
        if(low == null || low.isNaN())
            low = (float) 0;
        if(high == null || low.isNaN())
            high = Float.MAX_VALUE;
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByPriceBetween(low, high);
    }


    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPharmacyNameContainingIgnoreCase(String pharmacyName) {
        if(pharmacyName == null || pharmacyName.isEmpty() || pharmacyName.isBlank())
            return findAll();
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByPharmacyNameContainingIgnoreCase(pharmacyName);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByBrandedDrugNameContainingIgnoreCase(String brandedName) {
        if(brandedName == null || brandedName.isBlank() || brandedName.isEmpty())
            return findAll();
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByBrandedDrugNameContainingIgnoreCase(brandedName);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndTextAndPharmacyName(Integer quantity, Float low, Float high, String brandedName, String genericName, String pharmacyName) {
        Set<BrandedDrugsAvailabilityView> quantitySet = new HashSet<>(findBrandedDrugsAvailabilityViewByQuantityGreaterThan(quantity));
        Set<BrandedDrugsAvailabilityView> priceRangeSet = new HashSet<>(findBrandedDrugsAvailabilityViewByPriceBetween(low, high));
        Set<BrandedDrugsAvailabilityView> brandedDrugNameSet = new HashSet<>(findBrandedDrugsAvailabilityViewByBrandedDrugNameContainingIgnoreCase(brandedName));
        Set<BrandedDrugsAvailabilityView> genericTextSet = new HashSet<>(findBrandedDrugsAvailabilityViewByGenericName(genericName));
        Set<BrandedDrugsAvailabilityView> pharmacyNameSet = new HashSet<>(findBrandedDrugsAvailabilityViewByPharmacyNameContainingIgnoreCase(pharmacyName));
        quantitySet.retainAll(priceRangeSet);
        quantitySet.retainAll(brandedDrugNameSet);
        quantitySet.retainAll(genericTextSet);
        quantitySet.retainAll(pharmacyNameSet);
       return quantitySet.stream().toList();

    }

}
