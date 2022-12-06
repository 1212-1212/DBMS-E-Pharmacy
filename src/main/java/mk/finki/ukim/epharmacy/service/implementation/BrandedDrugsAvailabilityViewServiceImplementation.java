package mk.finki.ukim.epharmacy.service.implementation;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;
import mk.finki.ukim.epharmacy.repository.BrandedDrugsAvailabilityViewRepository;
import mk.finki.ukim.epharmacy.service.BrandedDrugsAvailabilityViewService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BrandedDrugsAvailabilityViewServiceImplementation implements BrandedDrugsAvailabilityViewService {

    private final BrandedDrugsAvailabilityViewRepository brandedDrugsAvailabilityViewRepository;

    public BrandedDrugsAvailabilityViewServiceImplementation(BrandedDrugsAvailabilityViewRepository brandedDrugsAvailabilityViewRepository) {
        this.brandedDrugsAvailabilityViewRepository = brandedDrugsAvailabilityViewRepository;
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findAll() {
        return brandedDrugsAvailabilityViewRepository.findAll();
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByGenericName(String genericName) {
        return findAll().stream()
                .filter(drug -> drug.getKey().getGenericName().equals(genericName))
                .collect(Collectors.toList());
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(Integer quantity) {
        return brandedDrugsAvailabilityViewRepository.findBrandedDrugsAvailabilityViewByQuantityGreaterThan(quantity);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(Float low, Float high) {
        return brandedDrugsAvailabilityViewRepository.findBrandedDrugsAvailabilityViewByPriceBetween(low, high);
    }

    @Override
    public List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityBySearchText(String text) {

        return brandedDrugsAvailabilityViewRepository.findAll()
                .stream()
                .filter(drug -> drug.getKey().getBrandedDrugName().contains(text) ||
                        drug.getKey().getManufacturerName().contains(text) || drug.getKey().getPharmacyName().contains(text) ||
                        drug.getKey().getStreetName().contains(text))
                .collect(Collectors.toList());
    }

    public List<BrandedDrugsAvailabilityView> findByPriceRangeQuantityAndText(Integer quantity, Float low, Float high, String text, String genericName) {

        Set<BrandedDrugsAvailabilityView> quantitySet = new HashSet<>(findBrandedDrugsAvailabilityViewByQuantityGreaterThan(quantity));
        Set<BrandedDrugsAvailabilityView> priceRangeSet = new HashSet<>(findBrandedDrugsAvailabilityViewByPriceBetween(low, high));
        Set<BrandedDrugsAvailabilityView> textSet = new HashSet<>(findBrandedDrugsAvailabilityBySearchText(text));
        Set<BrandedDrugsAvailabilityView> genericTextSet = new HashSet<>(genericName.equals("All") ? findAll() : findBrandedDrugsAvailabilityViewByGenericName(genericName));
        quantitySet.retainAll(priceRangeSet);
        quantitySet.retainAll(textSet);
        quantitySet.retainAll(genericTextSet);
        return quantitySet.stream().toList();
    }
}
