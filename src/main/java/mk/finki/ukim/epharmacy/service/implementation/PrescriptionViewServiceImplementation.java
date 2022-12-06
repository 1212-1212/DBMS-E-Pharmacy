package mk.finki.ukim.epharmacy.service.implementation;

import mk.finki.ukim.epharmacy.model.views.PrescriptionView;
import mk.finki.ukim.epharmacy.repository.PrescriptionViewRepository;
import mk.finki.ukim.epharmacy.service.PrescriptionViewService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PrescriptionViewServiceImplementation implements PrescriptionViewService {

    private final PrescriptionViewRepository prescriptionViewRepository;

    public PrescriptionViewServiceImplementation(PrescriptionViewRepository prescriptionViewRepository) {
        this.prescriptionViewRepository = prescriptionViewRepository;
    }
    @Override
    public List<PrescriptionView> findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName)
    {
        return prescriptionViewRepository.findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName, lastName);
    }

    @Override
    public List<PrescriptionView> findAll() {
        return prescriptionViewRepository.findAll();
    }

    @Override
    public List<PrescriptionView> findPrescriptionViewsByPatientTextOrGenericName(String text, String genericName) {
        Set<PrescriptionView> set =  new HashSet<>(findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(text, text));
        set.retainAll(genericName.isEmpty() ?findAll() :findPrescriptionViewsByGenericName(genericName));
        return set.stream().toList();
    }


    @Override
    public List<PrescriptionView> findPrescriptionViewsByGenericName(String genericName) {
        return prescriptionViewRepository.findPrescriptionViewsByGenericName(genericName);
    }
}
