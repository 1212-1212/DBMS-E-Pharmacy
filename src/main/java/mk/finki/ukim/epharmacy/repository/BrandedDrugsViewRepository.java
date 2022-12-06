package mk.finki.ukim.epharmacy.repository;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.views.BrandedDrugsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandedDrugsViewRepository extends JpaRepository<BrandedDrugsView, BrandedDrugKey> {
        List<BrandedDrugsView> findBrandedDrugsViewByBrandedDrugNameContainingIgnoreCaseOrGenericContainingIgnoreCase(String brandedNameText, String genericNameText);
}
