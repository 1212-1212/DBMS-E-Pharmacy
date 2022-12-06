package mk.finki.ukim.epharmacy.service;

import mk.finki.ukim.epharmacy.model.views.BrandedDrugsView;

import java.util.List;

public interface BrandedDrugsViewService {

    List<BrandedDrugsView> findAll();
    List<BrandedDrugsView> findBrandedDrugsViewByBrandedDrugNameContainingIgnoreCaseOrGenericContainingIgnoreCase(String brandedNameText, String genericNameText);


}
