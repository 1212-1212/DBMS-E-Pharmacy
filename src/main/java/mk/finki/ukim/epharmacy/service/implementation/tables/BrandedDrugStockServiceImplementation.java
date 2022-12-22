package mk.finki.ukim.epharmacy.service.implementation.tables;

import jakarta.transaction.Transactional;
import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrugStock;
import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;
import mk.finki.ukim.epharmacy.repository.tables.BrandedDrugStockRepository;
import mk.finki.ukim.epharmacy.service.interfaces.tables.BrandedDrugStockService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandedDrugStockServiceImplementation implements BrandedDrugStockService {

    private final BrandedDrugStockRepository brandedDrugStockRepository;

    public BrandedDrugStockServiceImplementation(BrandedDrugStockRepository brandedDrugStockRepository) {
        this.brandedDrugStockRepository = brandedDrugStockRepository;
    }

    @Override
    public List<BrandedDrugStock> findAll() {
        return brandedDrugStockRepository.findAll();
    }

    @Override
    public void edit(BrandedDrugStock brandedDrugStock, OrderShoppingCart order) {
        brandedDrugStock.setQuantity(brandedDrugStock.getQuantity() - order.getQuantity());
        brandedDrugStockRepository.save(brandedDrugStock);
    }

    @Transactional
    @Override
    public void editAll(BrandedDrugStock brandedDrugStock, Set<OrderShoppingCart> orders) {

        orders.stream()
                .forEach(orderShoppingCart -> edit(brandedDrugStock, orderShoppingCart));

    }

    @Override
    public Optional<BrandedDrugStock> findByKey(BrandedDrugStockKey key) {
        return brandedDrugStockRepository.findById(key);
    }

    @Override
    public Double total(Map<Long, HashSet<OrderShoppingCart>> map) {
        return map.values().stream().flatMap(Collection::stream)
                .mapToDouble(order -> order.getQuantity()* order.getPrice())
                .sum();
    }
}
