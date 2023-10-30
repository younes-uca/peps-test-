package ma.peps.sqli.dao.facade.history.order;

import ma.peps.sqli.zynerator.repository.AbstractHistoryRepository;
import ma.peps.sqli.bean.history.order.OrderBoutiqueHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBoutiqueHistoryDao extends AbstractHistoryRepository<OrderBoutiqueHistory,Long> {

}
