package mk.finki.ukim.epharmacy.repository.views.aggregations;

import mk.finki.ukim.epharmacy.model.primaryKeys.AvailabilityInPharmacyByGenericViewKey;
import mk.finki.ukim.epharmacy.model.views.aggregations.AvailabilityInPharmacyByGenericView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityInPharmacyByGenericViewRepository extends JpaRepository<AvailabilityInPharmacyByGenericView, AvailabilityInPharmacyByGenericViewKey> {

}
