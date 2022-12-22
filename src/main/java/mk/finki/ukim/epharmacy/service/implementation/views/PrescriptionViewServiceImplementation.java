package mk.finki.ukim.epharmacy.service.implementation.views;

import mk.finki.ukim.epharmacy.model.views.PrescriptionView;
import mk.finki.ukim.epharmacy.repository.views.PrescriptionViewRepository;
import mk.finki.ukim.epharmacy.service.interfaces.views.PrescriptionViewService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrescriptionViewServiceImplementation implements PrescriptionViewService {

    private final PrescriptionViewRepository prescriptionViewRepository;

    public PrescriptionViewServiceImplementation(PrescriptionViewRepository prescriptionViewRepository) {
        this.prescriptionViewRepository = prescriptionViewRepository;
    }

    @Override
    public List<PrescriptionView> findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String text) {
        if(text == null || text.isBlank() || text.isEmpty())
        {
            return findAll();
        }
        return prescriptionViewRepository.findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(text,text);
    }

    @Override
    public List<PrescriptionView> findAll() {
        return prescriptionViewRepository.findAll();
    }

    @Override
    public List<PrescriptionView> findPrescriptionViewsByPatientTextOrGenericNameOrMarkAsUsed(String text, String genericName, Boolean markAsUsed) {
        Set<PrescriptionView> set =  new HashSet<>(findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(text));
        set.retainAll(findPrescriptionViewsByGenericName(genericName));
        set.retainAll(findPrescriptionViewsByMarkedAsUsed(markAsUsed));
        return set.stream().toList();
    }

    @Override
    public List<PrescriptionView> findPrescriptionViewsByMarkedAsUsed(Boolean markAsUsed) {
        if(markAsUsed == null)
            return findAll();
        return prescriptionViewRepository.findPrescriptionViewsByMarkedAsUsed(markAsUsed);
    }

    @Override
    public List<PrescriptionView> findPrescriptionViewsByGenericName(String genericName) {
        if(genericName == null || genericName.equals("All") || genericName.isEmpty() || genericName.isBlank())
            return findAll();
        return prescriptionViewRepository.findPrescriptionViewsByGenericName(genericName);
    }
}
