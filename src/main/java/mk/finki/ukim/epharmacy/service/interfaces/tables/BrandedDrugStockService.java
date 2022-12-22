package mk.finki.ukim.epharmacy.service.interfaces.tables;

import mk.finki.ukim.epharmacy.model.primaryKeys.BrandedDrugStockKey;
import mk.finki.ukim.epharmacy.model.tables.BrandedDrugStock;
import mk.finki.ukim.epharmacy.model.tables.OrderShoppingCart;


import java.util.*;

public interface BrandedDrugStockService {

    List<BrandedDrugStock> findAll();

    void edit(BrandedDrugStock brandedDrugStock, OrderShoppingCart order);

    void editAll(BrandedDrugStock brandedDrugStock, Set<OrderShoppingCart> orders);

    Optional<BrandedDrugStock> findByKey(BrandedDrugStockKey key);

    Double total(Map<Long, HashSet<OrderShoppingCart>> map);


}
