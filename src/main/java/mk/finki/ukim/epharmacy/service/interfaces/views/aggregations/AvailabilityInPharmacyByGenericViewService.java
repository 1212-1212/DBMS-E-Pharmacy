package mk.finki.ukim.epharmacy.service.interfaces.views.aggregations;

import mk.finki.ukim.epharmacy.model.views.aggregations.AvailabilityInPharmacyByGenericView;

import java.util.List;

public interface AvailabilityInPharmacyByGenericViewService {

    List<AvailabilityInPharmacyByGenericView> findAll();
}
