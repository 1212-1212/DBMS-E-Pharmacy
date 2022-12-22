package mk.finki.ukim.epharmacy.repository.views;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;
import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandedDrugsAvailabilityRepository extends JpaRepository<BrandedDrugsAvailabilityView, BrandedDrugStockKey> {
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(int quantity);
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(float low, float high);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPharmacyName(String pharmacyName);

    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByGenericName(String genericName);
}
