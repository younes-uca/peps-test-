package  ma.peps.sqli.dao.specification.core.catalog;

import ma.peps.sqli.zynerator.specification.AbstractSpecification;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCategoryCriteria;
import ma.peps.sqli.bean.core.catalog.ProductCategory;


public class ProductCategorySpecification extends  AbstractSpecification<ProductCategoryCriteria, ProductCategory>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public ProductCategorySpecification(ProductCategoryCriteria criteria) {
        super(criteria);
    }

    public ProductCategorySpecification(ProductCategoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
