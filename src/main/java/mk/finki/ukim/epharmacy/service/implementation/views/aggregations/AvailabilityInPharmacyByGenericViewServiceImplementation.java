package mk.finki.ukim.epharmacy.service.implementation.views.aggregations;

import mk.finki.ukim.epharmacy.model.views.aggregations.AvailabilityInPharmacyByGenericView;
import mk.finki.ukim.epharmacy.repository.views.aggregations.AvailabilityInPharmacyByGenericViewRepository;
import mk.finki.ukim.epharmacy.service.interfaces.views.aggregations.AvailabilityInPharmacyByGenericViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityInPharmacyByGenericViewServiceImplementation implements AvailabilityInPharmacyByGenericViewService {

    private final AvailabilityInPharmacyByGenericViewRepository availabilityInPharmacyByGenericViewRepository;

    public AvailabilityInPharmacyByGenericViewServiceImplementation(AvailabilityInPharmacyByGenericViewRepository availabilityInPharmacyByGenericViewRepository) {
        this.availabilityInPharmacyByGenericViewRepository = availabilityInPharmacyByGenericViewRepository;
    }

    @Override
    public List<AvailabilityInPharmacyByGenericView> findAll() {
        return availabilityInPharmacyByGenericViewRepository.findAll();
    }
}
