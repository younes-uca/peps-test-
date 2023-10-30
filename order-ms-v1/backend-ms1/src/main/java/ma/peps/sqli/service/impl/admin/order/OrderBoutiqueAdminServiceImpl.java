package ma.peps.sqli.service.impl.admin.order;


import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.bean.core.order.OrderLine;
import ma.peps.sqli.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.peps.sqli.dao.facade.core.order.OrderBoutiqueDao;
import ma.peps.sqli.dao.specification.core.order.OrderBoutiqueSpecification;
import ma.peps.sqli.service.facade.admin.commun.OrderStatusAdminService;
import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.service.facade.admin.order.OrderLineAdminService;
import ma.peps.sqli.ws.dto.order.OrderBoutiqueDto;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import ma.peps.sqli.zynerator.util.ListUtil;
import ma.peps.sqli.zynerator.util.VelocityPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderBoutiqueAdminServiceImpl extends AbstractServiceImpl<OrderBoutique, OrderBoutiqueCriteria, OrderBoutiqueDao> implements OrderBoutiqueAdminService {
    public static final String TEMPLATE = "template/orderBoutique.vm";
    public static final String FILE_NAME = "orderBoutique.pdf";


    @Override
    public HttpEntity<byte[]> createPdf(OrderBoutiqueDto dto) throws Exception {
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public OrderBoutique save(OrderBoutique t) {
        return dao.save(t);
    }

    public OrderBoutique findWithAssociatedLists(Long id) {
        OrderBoutique result = dao.findById(id).orElse(null);
        if (result != null && result.getId() != null) {
            result.setOrderLines(orderLineService.findByOrderBoutiqueId(id));
        }
        return result;
    }

    @Transactional
    public void deleteAssociatedLists(Long id) {
        orderLineService.deleteByOrderBoutiqueId(id);
    }


    public void updateWithAssociatedLists(OrderBoutique orderBoutique) {
        if (orderBoutique != null && orderBoutique.getId() != null) {
            List<List<OrderLine>> resultOrderLines = orderLineService.getToBeSavedAndToBeDeleted(orderLineService.findByOrderBoutiqueId(orderBoutique.getId()), orderBoutique.getOrderLines());
            orderLineService.delete(resultOrderLines.get(1));
            ListUtil.emptyIfNull(resultOrderLines.get(0)).forEach(e -> e.setOrderBoutique(orderBoutique));
            orderLineService.update(resultOrderLines.get(0), true);
        }
    }


    public OrderBoutique findByReferenceEntity(OrderBoutique t) {
        return dao.findByReference(t.getReference());
    }

    public List<OrderBoutique> findByOrderStatusId(Long id) {
        return dao.findByOrderStatusId(id);
    }

    public int deleteByOrderStatusId(Long id) {
        return dao.deleteByOrderStatusId(id);
    }

    public long countByOrderStatusCode(String code) {
        return dao.countByOrderStatusCode(code);
    }


    public void configure() {
        super.configure(OrderBoutique.class, OrderBoutiqueSpecification.class);
    }


    @Autowired
    private OrderStatusAdminService orderStatusService;
    @Autowired
    private OrderLineAdminService orderLineService;
    @Autowired
    private VelocityPdf velocityPdf;

    public OrderBoutiqueAdminServiceImpl(OrderBoutiqueDao dao) {
        super(dao);
    }

}
