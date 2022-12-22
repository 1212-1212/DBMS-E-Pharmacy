package mk.finki.ukim.epharmacy.service.implementation.views.aggregations;

import mk.finki.ukim.epharmacy.model.views.aggregations.MostSoldProductMonthlyView;
import mk.finki.ukim.epharmacy.repository.views.aggregations.MostSoldProductMonthlyViewRepository;
import mk.finki.ukim.epharmacy.service.interfaces.views.aggregations.MostSoldProductMonthlyViewService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MostSoldProductMonthlyViewServiceImplementation implements MostSoldProductMonthlyViewService {

    private final MostSoldProductMonthlyViewRepository mostSoldProductMonthlyViewRepository;

    public MostSoldProductMonthlyViewServiceImplementation(MostSoldProductMonthlyViewRepository mostSoldProductMonthlyViewRepository) {
        this.mostSoldProductMonthlyViewRepository = mostSoldProductMonthlyViewRepository;
    }

    @Override
    public List<MostSoldProductMonthlyView> findAll() {
        return mostSoldProductMonthlyViewRepository.findAll();
    }
}
