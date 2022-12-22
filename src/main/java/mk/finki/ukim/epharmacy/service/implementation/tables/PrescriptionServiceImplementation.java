package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.model.tables.Patient;
import mk.finki.ukim.epharmacy.model.tables.Prescription;
import mk.finki.ukim.epharmacy.repository.tables.PrescriptionRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PrescriptionServiceImplementation implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImplementation(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }


    @Override
    public List<Prescription> findAllByPatient(Patient patient) {
        return prescriptionRepository.findAllByPatient(patient);
    }

    @Override
    public List<Prescription> findAllByGenericDrug(GenericDrug genericDrug) {
        return prescriptionRepository.findAllByGenericDrug(genericDrug);
    }

    @Override
    public List<Prescription> findAllByMarkedAsUsed(Boolean markedAsUsed) {
        return prescriptionRepository.findAllByMarkedAsUsed(markedAsUsed);
    }

    @Override
    public List<Prescription> findAllByPatientAndGenericDrugAndMarkedAsUsed(Patient patient, GenericDrug genericDrug, Boolean markedAsUsed) {
        HashSet<Prescription> patientSet =  new HashSet<>(findAllByPatient(patient));
        HashSet<Prescription> genericDrugSet = new HashSet<>(findAllByGenericDrug(genericDrug));
        HashSet<Prescription> markedAsUsedSet = new HashSet<>(findAllByMarkedAsUsed(markedAsUsed));
        patientSet.retainAll(genericDrugSet);
        patientSet.retainAll(markedAsUsedSet);
        return patientSet.stream().toList();
    }

    @Override
    public Prescription save(Prescription prescription) {
       return prescriptionRepository.save(prescription);
    }
}
