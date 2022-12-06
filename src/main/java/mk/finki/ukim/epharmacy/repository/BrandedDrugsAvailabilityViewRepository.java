package mk.finki.ukim.epharmacy.repository;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugsAvailabilityKey;
import mk.finki.ukim.epharmacy.model.views.BrandedDrugsAvailabilityView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandedDrugsAvailabilityViewRepository extends JpaRepository<BrandedDrugsAvailabilityView, BrandedDrugsAvailabilityKey> {
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByQuantityGreaterThan(int quantity);
    List<BrandedDrugsAvailabilityView> findBrandedDrugsAvailabilityViewByPriceBetween(float low, float high);
}
