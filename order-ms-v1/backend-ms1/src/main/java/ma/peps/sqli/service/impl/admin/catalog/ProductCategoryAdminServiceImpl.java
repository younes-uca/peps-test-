package ma.peps.sqli.service.impl.admin.catalog;


import ma.peps.sqli.bean.core.catalog.ProductCategory;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCategoryCriteria;
import ma.peps.sqli.dao.facade.core.catalog.ProductCategoryDao;
import ma.peps.sqli.dao.specification.core.catalog.ProductCategorySpecification;
import ma.peps.sqli.service.facade.admin.catalog.ProductCategoryAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import ma.peps.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProductCategoryAdminServiceImpl extends AbstractServiceImpl<ProductCategory, ProductCategoryCriteria, ProductCategoryDao> implements ProductCategoryAdminService {





    public ProductCategory findByReferenceEntity(ProductCategory t){
        return  dao.findByCode(t.getCode());
    }







    public void configure() {
        super.configure(ProductCategory.class, ProductCategorySpecification.class);
    }



    public ProductCategoryAdminServiceImpl(ProductCategoryDao dao) {
        super(dao);
    }

}
