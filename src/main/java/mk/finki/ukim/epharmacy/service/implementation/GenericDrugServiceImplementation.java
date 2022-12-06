package mk.finki.ukim.epharmacy.service.implementation;

import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.repository.GenericDrugRepository;
import mk.finki.ukim.epharmacy.service.GenericDrugService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenericDrugServiceImplementation implements GenericDrugService {

    private final GenericDrugRepository genericDrugRepository;

    public GenericDrugServiceImplementation(GenericDrugRepository genericDrugRepository) {
        this.genericDrugRepository = genericDrugRepository;
    }

    @Override
    public Optional<GenericDrug> findByGeneric(String generic) {
        return genericDrugRepository.findByGeneric(generic);
    }

    @Override
    public Optional<GenericDrug> findById(Long id) {
        return genericDrugRepository.findById(id);
    }

    @Override
    public List<GenericDrug> findAll() {
        return genericDrugRepository.findAll();
    }
}
