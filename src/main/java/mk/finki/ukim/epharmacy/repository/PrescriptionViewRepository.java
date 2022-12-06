package mk.finki.ukim.epharmacy.repository;

import mk.finki.ukim.epharmacy.model.views.PrescriptionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrescriptionViewRepository extends JpaRepository<PrescriptionView, String> {

    List<PrescriptionView> findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    List<PrescriptionView> findPrescriptionViewsByGenericName(String genericName);





}
