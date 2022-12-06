package mk.finki.ukim.epharmacy.service;

import mk.finki.ukim.epharmacy.model.views.PrescriptionView;

import java.util.List;

public interface PrescriptionViewService {

    List<PrescriptionView> findPrescriptionViewsByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    List<PrescriptionView> findPrescriptionViewsByGenericName(String genericName);


    List<PrescriptionView> findAll();

    List<PrescriptionView> findPrescriptionViewsByPatientTextOrGenericName(String text, String genericName);
}
