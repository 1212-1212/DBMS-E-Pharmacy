package mk.finki.ukim.epharmacy.service;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrug;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BrandedDrugService {

    BrandedDrug save(String manufacturerName, String brandedDrugName, LocalDateTime expirationDate, String genericDrugName);
    Optional<BrandedDrug> findByKey(BrandedDrugKey key);

    List<BrandedDrug> findAll();
}
