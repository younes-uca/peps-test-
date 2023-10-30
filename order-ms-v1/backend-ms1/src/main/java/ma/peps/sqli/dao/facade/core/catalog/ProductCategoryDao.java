package ma.peps.sqli.dao.facade.core.catalog;

import org.springframework.data.jpa.repository.Query;
import ma.peps.sqli.zynerator.repository.AbstractRepository;
import ma.peps.sqli.bean.core.catalog.ProductCategory;
import org.springframework.stereotype.Repository;
import ma.peps.sqli.bean.core.catalog.ProductCategory;
import java.util.List;


@Repository
public interface ProductCategoryDao extends AbstractRepository<ProductCategory,Long>  {
    ProductCategory findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ProductCategory(item.id,item.libelle) FROM ProductCategory item")
    List<ProductCategory> findAllOptimized();

}
