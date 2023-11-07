package ma.peps.sqli.service.core.facade.admin.order;

import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.peps.sqli.ws.dto.order.OrderBoutiqueDto;
import ma.peps.sqli.zynerator.service.IService;
import org.springframework.http.HttpEntity;

import java.util.List;


public interface OrderBoutiqueAdminService extends IService<OrderBoutique, OrderBoutiqueCriteria> {

    List<OrderBoutique> findByOrderStatusId(Long id);

    int deleteByOrderStatusId(Long id);

    long countByOrderStatusCode(String code);

    OrderBoutique save(OrderBoutique t);

    HttpEntity<byte[]> createPdf(OrderBoutiqueDto dto) throws Exception;

    void deleteAll();

}
