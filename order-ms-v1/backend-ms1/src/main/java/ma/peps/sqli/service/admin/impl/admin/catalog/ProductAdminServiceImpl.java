package ma.peps.sqli.service.core.facade.impl.admin.catalog;


import ma.peps.sqli.bean.core.catalog.Product;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCriteria;
import ma.peps.sqli.dao.facade.core.catalog.ProductDao;
import ma.peps.sqli.dao.specification.core.catalog.ProductSpecification;
import ma.peps.sqli.service.core.facade.admin.catalog.ProductAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import ma.peps.sqli.service.core.facade.admin.catalog.ProductCategoryAdminService;

@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product, ProductCriteria, ProductDao> implements ProductAdminService {





    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }

    public List<Product> findByProductCategoryId(Long id){
        return dao.findByProductCategoryId(id);
    }
    public int deleteByProductCategoryId(Long id){
        return dao.deleteByProductCategoryId(id);
    }
    public long countByProductCategoryCode(String code){
        return dao.countByProductCategoryCode(code);
    }






    public void configure() {
        super.configure(Product.class, ProductSpecification.class);
    }


    @Autowired
    private ProductCategoryAdminService productCategoryService ;

    public ProductAdminServiceImpl(ProductDao dao) {
        super(dao);
    }

}
