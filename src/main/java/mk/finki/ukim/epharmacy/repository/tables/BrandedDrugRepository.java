package mk.finki.ukim.epharmacy.repository.tables;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandedDrugRepository extends JpaRepository<BrandedDrug, BrandedDrugKey> {

    List<BrandedDrug> findAllByBrandedDrugNameContainingIgnoreCase(String text);
}
