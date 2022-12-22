package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.tables.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> findAll();

    Patient save(Patient patient);

    Optional<Patient> findById(Long id);
}
