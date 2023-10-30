package  ma.peps.sqli.dao.specification.core.commun;

import ma.peps.sqli.zynerator.specification.AbstractSpecification;
import ma.peps.sqli.dao.criteria.core.commun.OrderStatusCriteria;
import ma.peps.sqli.bean.core.commun.OrderStatus;


public class OrderStatusSpecification extends  AbstractSpecification<OrderStatusCriteria, OrderStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public OrderStatusSpecification(OrderStatusCriteria criteria) {
        super(criteria);
    }

    public OrderStatusSpecification(OrderStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
