package ma.peps.sqli.service.facade.admin.commun;

import java.util.List;
import ma.peps.sqli.bean.core.commun.OrderStatus;
import ma.peps.sqli.dao.criteria.core.commun.OrderStatusCriteria;
import ma.peps.sqli.zynerator.service.IService;

import ma.peps.sqli.ws.dto.commun.OrderStatusDto;
import org.springframework.http.HttpEntity;


public interface OrderStatusAdminService extends  IService<OrderStatus,OrderStatusCriteria>  {



    HttpEntity<byte[]> createPdf(OrderStatusDto dto) throws Exception;

}
