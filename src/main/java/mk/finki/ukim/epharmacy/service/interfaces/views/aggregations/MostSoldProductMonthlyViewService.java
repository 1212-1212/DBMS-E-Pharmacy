package mk.finki.ukim.epharmacy.service.interfaces.views.aggregations;

import mk.finki.ukim.epharmacy.model.views.aggregations.MostSoldProductMonthlyView;

import java.util.List;

public interface MostSoldProductMonthlyViewService {

    List<MostSoldProductMonthlyView> findAll();
}
