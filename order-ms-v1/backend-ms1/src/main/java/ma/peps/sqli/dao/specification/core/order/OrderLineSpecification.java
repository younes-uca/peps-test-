package  ma.peps.sqli.dao.specification.core.order;

import ma.peps.sqli.zynerator.specification.AbstractSpecification;
import ma.peps.sqli.dao.criteria.core.order.OrderLineCriteria;
import ma.peps.sqli.bean.core.order.OrderLine;


public class OrderLineSpecification extends  AbstractSpecification<OrderLineCriteria, OrderLine>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("quantityReceived", criteria.getQuantityReceived(), criteria.getQuantityReceivedMin(), criteria.getQuantityReceivedMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","code", criteria.getProduct()==null?null:criteria.getProduct().getCode());
        addPredicateFk("orderBoutique","id", criteria.getOrderBoutique()==null?null:criteria.getOrderBoutique().getId());
        addPredicateFk("orderBoutique","id", criteria.getOrderBoutiques());
        addPredicateFk("orderBoutique","reference", criteria.getOrderBoutique()==null?null:criteria.getOrderBoutique().getReference());
    }

    public OrderLineSpecification(OrderLineCriteria criteria) {
        super(criteria);
    }

    public OrderLineSpecification(OrderLineCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
