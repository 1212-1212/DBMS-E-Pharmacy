package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrug;
import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.repository.tables.BrandedDrugRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.BrandedDrugService;
import mk.finki.ukim.epharmacy.service.interfaces.tables.GenericDrugService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BrandedDrugServiceImplementation implements BrandedDrugService {

    private final BrandedDrugRepository brandedDrugRepository;
    private final GenericDrugService genericDrugService;

    public static String PRESCRIPTION_TEXT = "Prescription Only";

    public static String AUTHORITY_TEXT = "Authority Script";


    public BrandedDrugServiceImplementation(BrandedDrugRepository brandedDrugRepository, GenericDrugService genericDrugService) {
        this.brandedDrugRepository = brandedDrugRepository;
        this.genericDrugService = genericDrugService;
    }

    @Override
    public List<BrandedDrug> findAll() {
        return brandedDrugRepository.findAll();
    }

    @Override
    public Optional<BrandedDrug> findByKey(BrandedDrugKey key) {
        return findAll().stream().filter(brandedDrug -> brandedDrug.getBrandedDrugKey().equals(key))
                .findFirst();
    }

    @Override
    public BrandedDrug save(String manufacturerName, String brandedDrugName, String genericDrugName) {
        Optional<GenericDrug> optional = genericDrugService.findByGeneric(genericDrugName);
        if(optional.isEmpty())
            throw new RuntimeException();
        Long genericDrugId = optional.get().getGenericDrugId();
        BrandedDrugKey key = new BrandedDrugKey(brandedDrugRepository.findAll().size()+1L,manufacturerName, genericDrugId);
        BrandedDrug  brandedDrug = new BrandedDrug(key, brandedDrugName, optional.get());
        return brandedDrugRepository.save(brandedDrug);
    }

    @Override
    public List<BrandedDrug> findAllByBrandedDrugNameContainingIgnoreCase(String text) {
        return brandedDrugRepository.findAllByBrandedDrugNameContainingIgnoreCase(text);
    }

    @Override
    public List<BrandedDrug> findAllByPrescriptionRequiredBrandedDrugs() {
        Set<BrandedDrug> prescriptionRequired= new HashSet<>(findAllByBrandedDrugNameContainingIgnoreCase(PRESCRIPTION_TEXT));
        Set<BrandedDrug> authorityScriptRequired= new HashSet<>(findAllByBrandedDrugNameContainingIgnoreCase(AUTHORITY_TEXT));
        prescriptionRequired.addAll(authorityScriptRequired);
        return prescriptionRequired.stream().toList();
    }
}
