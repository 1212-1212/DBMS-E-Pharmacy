package mk.finki.ukim.epharmacy.service.implementation.tables;

import mk.finki.ukim.epharmacy.model.tables.Bill;
import mk.finki.ukim.epharmacy.repository.tables.BillRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.BillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImplementation implements BillService {

    private final BillRepository billRepository;

    public BillServiceImplementation(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }
}
