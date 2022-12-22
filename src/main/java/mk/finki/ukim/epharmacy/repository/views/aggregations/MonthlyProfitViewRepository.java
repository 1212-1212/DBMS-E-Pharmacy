package mk.finki.ukim.epharmacy.repository.views.aggregations;

import mk.finki.ukim.epharmacy.model.primaryKeys.MonthlyProfitViewKey;
import mk.finki.ukim.epharmacy.model.views.aggregations.MonthlyProfitView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyProfitViewRepository extends JpaRepository<MonthlyProfitView, MonthlyProfitViewKey> {
}
