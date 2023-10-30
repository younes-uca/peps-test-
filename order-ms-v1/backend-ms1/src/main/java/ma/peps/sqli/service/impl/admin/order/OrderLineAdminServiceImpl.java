package ma.peps.sqli.service.impl.admin.order;


import ma.peps.sqli.bean.core.order.OrderLine;
import ma.peps.sqli.dao.criteria.core.order.OrderLineCriteria;
import ma.peps.sqli.dao.facade.core.order.OrderLineDao;
import ma.peps.sqli.dao.specification.core.order.OrderLineSpecification;
import ma.peps.sqli.service.facade.admin.order.OrderLineAdminService;
import ma.peps.sqli.zynerator.service.AbstractServiceImpl;
import ma.peps.sqli.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService ;
import ma.peps.sqli.bean.core.order.OrderBoutique ;
import ma.peps.sqli.service.facade.admin.catalog.ProductAdminService ;
import ma.peps.sqli.bean.core.catalog.Product ;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class OrderLineAdminServiceImpl extends AbstractServiceImpl<OrderLine, OrderLineCriteria, OrderLineDao> implements OrderLineAdminService {






    public List<OrderLine> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public long countByProductCode(String code){
        return dao.countByProductCode(code);
    }
    public List<OrderLine> findByOrderBoutiqueId(Long id){
        return dao.findByOrderBoutiqueId(id);
    }

    @Transactional
    public int deleteByOrderBoutiqueId(Long id){
        return dao.deleteByOrderBoutiqueId(id);
    }
    public long countByOrderBoutiqueReference(String reference){
        return dao.countByOrderBoutiqueReference(reference);
    }






    public void configure() {
        super.configure(OrderLine.class, OrderLineSpecification.class);
    }


    @Autowired
    private OrderBoutiqueAdminService orderBoutiqueService ;
    @Autowired
    private ProductAdminService productService ;

    public OrderLineAdminServiceImpl(OrderLineDao dao) {
        super(dao);
    }

}
