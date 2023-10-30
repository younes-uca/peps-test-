package  ma.peps.sqli.dao.specification.history.order;

import ma.peps.sqli.zynerator.specification.AbstractHistorySpecification;
import ma.peps.sqli.dao.criteria.history.order.OrderBoutiqueHistoryCriteria;
import ma.peps.sqli.bean.history.order.OrderBoutiqueHistory;


public class OrderBoutiqueHistorySpecification extends AbstractHistorySpecification<OrderBoutiqueHistoryCriteria, OrderBoutiqueHistory> {

    public OrderBoutiqueHistorySpecification(OrderBoutiqueHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderBoutiqueHistorySpecification(OrderBoutiqueHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
