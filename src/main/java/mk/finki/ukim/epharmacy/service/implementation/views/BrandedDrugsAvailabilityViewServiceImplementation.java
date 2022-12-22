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
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByPriceBetween(low, high);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPharmacyName(String pharmacyName) {
        return brandedDrugsAvailabilityRepository.findBrandedDrugsAvailabilityViewByPharmacyName(pharmacyName);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityBySearchText(String text) {

        return brandedDrugsAvailabilityRepository.findAll()
                .stream()
                .filter(drug -> drug.getBrandedDrugName().contains(text) ||
                        drug.getKey().getBrandedDrugKey().getManufacturerName().contains(text) || drug.getPharmacyName().contains(text) ||
                        drug.getStreetName().contains(text))
                .collect(Collectors.toList());
    }

    public List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndText(Integer quantity, Float low, Float high, String text, String genericName) {

        Set<BrandedDrugsAvailabilityView> quantitySet = new HashSet<>(findBrandedDrugsAvailabilityViewByQuantityGreaterThan(quantity));
        Set<BrandedDrugsAvailabilityView> priceRangeSet = new HashSet<>(findBrandedDrugsAvailabilityViewByPriceBetween(low, high));
        Set<BrandedDrugsAvailabilityView> textSet = new HashSet<>(findBrandedDrugsAvailabilityBySearchText(text));
        Set<BrandedDrugsAvailabilityView> genericTextSet = new HashSet<>(findBrandedDrugsAvailabilityViewByGenericName(genericName));
        quantitySet.retainAll(priceRangeSet);
        quantitySet.retainAll(textSet);
        quantitySet.retainAll(genericTextSet);
        return quantitySet.stream().toList();
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndTextAndPharmacyName(Integer quantity, Float low, Float high, String text, String genericName, String pharmacyName) {
       Set<BrandedDrugsAvailabilityView> result = new HashSet<>(findByPriceRangeQuantityAndText(quantity, low, high, text, genericName));
       result.retainAll(findBrandedDrugsAvailabilityViewByPharmacyName(pharmacyName));
       return result.stream().toList();

    }
}
