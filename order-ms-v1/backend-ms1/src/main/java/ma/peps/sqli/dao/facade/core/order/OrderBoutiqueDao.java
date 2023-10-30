package ma.peps.sqli.dao.facade.core.order;

import org.springframework.data.jpa.repository.Query;
import ma.peps.sqli.zynerator.repository.AbstractRepository;
import ma.peps.sqli.bean.core.order.OrderBoutique;
import org.springframework.stereotype.Repository;
import ma.peps.sqli.bean.core.order.OrderBoutique;
import java.util.List;


@Repository
public interface OrderBoutiqueDao extends AbstractRepository<OrderBoutique,Long>  {
    OrderBoutique findByReference(String reference);
    int deleteByReference(String reference);

    List<OrderBoutique> findByOrderStatusId(Long id);
    int deleteByOrderStatusId(Long id);
    long countByOrderStatusCode(String code);

    @Query("SELECT NEW OrderBoutique(item.id,item.reference) FROM OrderBoutique item")
    List<OrderBoutique> findAllOptimized();

}
