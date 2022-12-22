package mk.finki.ukim.epharmacy.service.implementation.views.aggregations;

import mk.finki.ukim.epharmacy.model.views.aggregations.MonthlyProfitView;
import mk.finki.ukim.epharmacy.repository.views.aggregations.MonthlyProfitViewRepository;
import mk.finki.ukim.epharmacy.service.interfaces.views.aggregations.MonthlyProfitViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyProfitViewServiceImplementation implements MonthlyProfitViewService {

    private final MonthlyProfitViewRepository monthlyProfitViewRepository;

    public MonthlyProfitViewServiceImplementation(MonthlyProfitViewRepository monthlyProfitViewRepository) {
        this.monthlyProfitViewRepository = monthlyProfitViewRepository;
    }

    @Override
    public List<MonthlyProfitView> findAll() {
        return monthlyProfitViewRepository.findAll();
    }
}
