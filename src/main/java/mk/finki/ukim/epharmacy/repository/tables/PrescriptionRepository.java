package mk.finki.ukim.epharmacy.repository.tables;


import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import mk.finki.ukim.epharmacy.model.tables.Patient;
import mk.finki.ukim.epharmacy.model.tables.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findAllByPatient(Patient patient);
    List<Prescription> findAllByGenericDrug(GenericDrug genericDrug);
    List<Prescription> findAllByMarkedAsUsed(Boolean markedAsUsed);

}
