package mk.finki.ukim.epharmacy.repository.tables;

import mk.finki.ukim.epharmacy.model.tables.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
