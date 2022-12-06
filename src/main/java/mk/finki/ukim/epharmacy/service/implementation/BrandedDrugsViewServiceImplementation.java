package mk.finki.ukim.epharmacy.service.implementation;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsView;
import mk.finki.ukim.epharmacy.repository.BrandedDrugsViewRepository;
import mk.finki.ukim.epharmacy.service.BrandedDrugsViewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandedDrugsViewServiceImplementation implements  BrandedDrugsViewService{


    private final BrandedDrugsViewRepository brandedDrugsViewRepository;

    public BrandedDrugsViewServiceImplementation(BrandedDrugsViewRepository brandedDrugsViewRepository) {
        this.brandedDrugsViewRepository = brandedDrugsViewRepository;
    }


    @Override
    public List<BrandedDrugsView> findAll() {
        return brandedDrugsViewRepository.findAll();
    }

    @Override
    public List<BrandedDrugsView> findBrandedDrugsViewByBrandedDrugNameContainingIgnoreCaseOrGenericContainingIgnoreCase(String brandedNameText, String genericNameText) {
        return brandedDrugsViewRepository.findBrandedDrugsViewByBrandedDrugNameContainingIgnoreCaseOrGenericContainingIgnoreCase(brandedNameText, genericNameText);
    }




}