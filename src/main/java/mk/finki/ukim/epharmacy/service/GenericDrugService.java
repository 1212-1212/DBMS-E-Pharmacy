package mk.finki.ukim.epharmacy.service;

import mk.finki.ukim.epharmacy.model.tables.GenericDrug;

import java.util.List;
import java.util.Optional;

public interface GenericDrugService {


    Optional<GenericDrug> findByGeneric(String generic);
    List<GenericDrug> findAll();

    Optional<GenericDrug> findById(Long id);



}
