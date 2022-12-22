package mk.finki.ukim.epharmacy.service.interfaces.views;

import mk.finki.ukim.epharmacy.model.views.PrescriptionView;

import java.util.List;

public interface PrescriptionViewService {

    List<PrescriptionView> findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    List<PrescriptionView> findPrescriptionViewsByGenericName(String genericName);


    List<PrescriptionView> findAll();

    List<PrescriptionView> findPrescriptionViewsByPatientTextOrGenericNameOrMarkAsUsed(String text, String genericName, Boolean markAsUsed);

    List<PrescriptionView> findPrescriptionViewsByMarkedAsUsed(Boolean markAsUsed);

}
