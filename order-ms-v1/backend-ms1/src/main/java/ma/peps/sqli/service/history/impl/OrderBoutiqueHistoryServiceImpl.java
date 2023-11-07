package ma.peps.sqli.service.history.impl;

import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.bean.history.order.OrderBoutiqueHistory;
import ma.peps.sqli.dao.criteria.history.order.OrderBoutiqueHistoryCriteria;
import ma.peps.sqli.dao.facade.history.order.OrderBoutiqueHistoryDao;
import ma.peps.sqli.service.core.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.service.history.facade.OrderBoutiqueHistoryService;
import ma.peps.sqli.ws.dto.order.OrderBoutiqueDto;
import ma.peps.sqli.zynerator.service.AbstractServiceHistoryImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderBoutiqueHistoryServiceImpl extends AbstractServiceHistoryImpl<OrderBoutiqueHistory, OrderBoutiqueDto, OrderBoutique, OrderBoutiqueHistoryCriteria, OrderBoutiqueHistoryDao, OrderBoutiqueAdminService> implements OrderBoutiqueHistoryService {
    protected OrderBoutiqueHistoryDao historyRepository;
    protected OrderBoutiqueAdminService service;

    public OrderBoutiqueHistoryServiceImpl(OrderBoutiqueHistoryDao historyRepository, OrderBoutiqueAdminService service) {
        super(historyRepository, service);
        this.historyRepository = historyRepository;
        this.service = service;
    }

    @Override
    public void configure() {
        super.configure(OrderBoutiqueHistory.class, OrderBoutiqueHistoryCriteria.class, OrderBoutique.class);
    }
}
