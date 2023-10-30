package ma.peps.sqli.service.facade.admin.catalog;

import java.util.List;
import ma.peps.sqli.bean.core.catalog.Product;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCriteria;
import ma.peps.sqli.zynerator.service.IService;



public interface ProductAdminService extends  IService<Product,ProductCriteria>  {

    List<Product> findByProductCategoryId(Long id);
    int deleteByProductCategoryId(Long id);
    long countByProductCategoryCode(String code);



}
