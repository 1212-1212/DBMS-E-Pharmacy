package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrug;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BrandedDrugService {

    BrandedDrug save(String manufacturerName, String brandedDrugName, String genericDrugName);
    Optional<BrandedDrug> findByKey(BrandedDrugKey key);

    List<BrandedDrug> findAllByBrandedDrugNameContainingIgnoreCase(String text);

    List<BrandedDrug> findAll();

    List<BrandedDrug> findAllByPrescriptionRequiredBrandedDrugs();
}
