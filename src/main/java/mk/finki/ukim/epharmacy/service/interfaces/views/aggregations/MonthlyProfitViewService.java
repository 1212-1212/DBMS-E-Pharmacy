package mk.finki.ukim.epharmacy.service.interfaces.views.aggregations;

import mk.finki.ukim.epharmacy.model.views.aggregations.MonthlyProfitView;

import java.util.List;

public interface MonthlyProfitViewService {

    List<MonthlyProfitView> findAll();
}
