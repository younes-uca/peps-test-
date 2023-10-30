package  ma.peps.sqli.dao.specification.core.catalog;

import ma.peps.sqli.zynerator.specification.AbstractSpecification;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCriteria;
import ma.peps.sqli.bean.core.catalog.Product;


public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("productCategory","id", criteria.getProductCategory()==null?null:criteria.getProductCategory().getId());
        addPredicateFk("productCategory","id", criteria.getProductCategorys());
        addPredicateFk("productCategory","code", criteria.getProductCategory()==null?null:criteria.getProductCategory().getCode());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
