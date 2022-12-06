package mk.finki.ukim.epharmacy.service.implementation;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrug;
import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.repository.BrandedDrugRepository;
import mk.finki.ukim.epharmacy.service.BrandedDrugService;
import mk.finki.ukim.epharmacy.service.GenericDrugService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BrandedDrugServiceImplementation implements BrandedDrugService {

    private final BrandedDrugRepository brandedDrugRepository;
    private final GenericDrugService genericDrugService;

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
    public BrandedDrug save(String manufacturerName, String brandedDrugName, LocalDateTime expirationDate, String genericDrugName) {
        Optional<GenericDrug> optional = genericDrugService.findByGeneric(genericDrugName);
        if(optional.isEmpty())
            throw new RuntimeException();
        Long genericDrugId = optional.get().getGenericDrugId();
        BrandedDrugKey key = new BrandedDrugKey(brandedDrugRepository.findAll().size()+1L,manufacturerName, genericDrugId);
        BrandedDrug  brandedDrug = new BrandedDrug(key, brandedDrugName, expirationDate, optional.get());
        return brandedDrugRepository.save(brandedDrug);
    }
}
