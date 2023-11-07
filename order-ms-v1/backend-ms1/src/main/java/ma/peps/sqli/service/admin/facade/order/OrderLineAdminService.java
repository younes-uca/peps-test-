package ma.peps.sqli.service.core.facade.admin.order;

import java.util.List;
import ma.peps.sqli.bean.core.order.OrderLine;
import ma.peps.sqli.dao.criteria.core.order.OrderLineCriteria;
import ma.peps.sqli.zynerator.service.IService;



public interface OrderLineAdminService extends  IService<OrderLine,OrderLineCriteria>  {

    List<OrderLine> findByProductId(Long id);
    int deleteByProductId(Long id);
    long countByProductCode(String code);
    List<OrderLine> findByOrderBoutiqueId(Long id);
    int deleteByOrderBoutiqueId(Long id);
    int deleteByOrderBoutiqueReference(String reference);
    long countByOrderBoutiqueReference(String reference);


    void deleteAll();
}
