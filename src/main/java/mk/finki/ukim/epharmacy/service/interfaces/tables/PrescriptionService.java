package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.model.tables.Patient;
import mk.finki.ukim.epharmacy.model.tables.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> findAllByPatient(Patient patient);
    List<Prescription> findAllByGenericDrug(GenericDrug genericDrug);
    List<Prescription> findAllByMarkedAsUsed(Boolean markedAsUsed);

    List<Prescription> findAllByPatientAndGenericDrugAndMarkedAsUsed(Patient patient, GenericDrug genericDrug, Boolean markedAsUsed);

    Prescription save(Prescription prescription);

}
