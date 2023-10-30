package ma.peps.sqli.service.facade.admin.order;

import java.util.List;
import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.peps.sqli.zynerator.service.IService;

import ma.peps.sqli.ws.dto.order.OrderBoutiqueDto;
import org.springframework.http.HttpEntity;


public interface OrderBoutiqueAdminService extends  IService<OrderBoutique,OrderBoutiqueCriteria>  {

    List<OrderBoutique> findByOrderStatusId(Long id);
    int deleteByOrderStatusId(Long id);
    long countByOrderStatusCode(String code);


    HttpEntity<byte[]> createPdf(OrderBoutiqueDto dto) throws Exception;

}
