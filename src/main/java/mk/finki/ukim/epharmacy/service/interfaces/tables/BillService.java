package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.tables.Bill;

import java.util.List;
import java.util.Optional;

public interface BillService {

    List<Bill> findAll();

    Optional<Bill> findById(Long id);

    Bill save(Bill bill);
}
