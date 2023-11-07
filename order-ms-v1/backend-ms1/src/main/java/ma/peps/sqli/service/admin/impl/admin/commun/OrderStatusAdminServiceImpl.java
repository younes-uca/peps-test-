package ma.peps.sqli.service.core.facade.impl.admin.commun;


import ma.peps.sqli.bean.core.commun.OrderStatus;
import ma.peps.sqli.dao.criteria.core.commun.OrderStatusCriteria;
import ma.peps.sqli.dao.facade.core.commun.OrderStatusDao;
import ma.peps.sqli.dao.specification.core.commun.OrderStatusSpecification;
import ma.peps.sqli.service.core.facade.admin.commun.OrderStatusAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import org.springframework.stereotype.Service;


import ma.peps.sqli.zynerator.util.VelocityPdf;
import ma.peps.sqli.ws.dto.commun.OrderStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderStatusAdminServiceImpl extends AbstractServiceImpl<OrderStatus, OrderStatusCriteria, OrderStatusDao> implements OrderStatusAdminService {
    public static final String TEMPLATE = "template/orderStatus.vm";
    public static final String FILE_NAME = "orderStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public OrderStatus findByReferenceEntity(OrderStatus t){
        return  dao.findByCode(t.getCode());
    }







    public void configure() {
        super.configure(OrderStatus.class, OrderStatusSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public OrderStatusAdminServiceImpl(OrderStatusDao dao) {
        super(dao);
    }

}
