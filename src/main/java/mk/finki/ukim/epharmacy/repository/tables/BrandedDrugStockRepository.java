package mk.finki.ukim.epharmacy.repository.tables;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrugStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandedDrugStockRepository extends JpaRepository<BrandedDrugStock, BrandedDrugStockKey> {

}
