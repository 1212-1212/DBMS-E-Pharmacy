package mk.finki.ukim.epharmacy.repository.views.aggregations;

import mk.finki.ukim.epharmacy.model.primaryKeys.MostSoldProductMonthlyViewKey;
import mk.finki.ukim.epharmacy.model.views.aggregations.MostSoldProductMonthlyView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MostSoldProductMonthlyViewRepository extends JpaRepository<MostSoldProductMonthlyView, MostSoldProductMonthlyViewKey> {


}
