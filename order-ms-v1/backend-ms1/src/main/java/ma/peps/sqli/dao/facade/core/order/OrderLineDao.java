package ma.peps.sqli.dao.facade.core.order;

import ma.peps.sqli.zynerator.repository.AbstractRepository;
import ma.peps.sqli.bean.core.order.OrderLine;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OrderLineDao extends AbstractRepository<OrderLine,Long>  {

    List<OrderLine> findByProductId(Long id);
    int deleteByProductId(Long id);
    long countByProductCode(String code);
    List<OrderLine> findByOrderBoutiqueId(Long id);
    int deleteByOrderBoutiqueId(Long id);
    long countByOrderBoutiqueReference(String reference);


}
