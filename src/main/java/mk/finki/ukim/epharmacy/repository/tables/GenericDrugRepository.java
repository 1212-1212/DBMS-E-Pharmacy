package mk.finki.ukim.epharmacy.repository.tables;

import mk.finki.ukim.epharmacy.model.tables.GenericDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericDrugRepository extends JpaRepository<GenericDrug, Long> {

    Optional<GenericDrug> findByGeneric(String generic);
}
