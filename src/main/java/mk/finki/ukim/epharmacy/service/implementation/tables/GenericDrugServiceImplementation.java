package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.repository.tables.GenericDrugRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.GenericDrugService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<String> mapGenericDrugObjectsToGenericNames(List<GenericDrug> list) {
        return list.stream().map(GenericDrug::getGeneric).collect(Collectors.toList());
    }

    @Override
    public List<GenericDrug> findAll() {
        return genericDrugRepository.findAll();
    }

    @Override
    public Map<Long, String> toMap() {
        return findAll()
                .stream()
                .collect(Collectors.toMap(
                        GenericDrug::getGenericDrugId,
                        GenericDrug::getGeneric
                ));
    }
}
