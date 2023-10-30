package ma.peps.sqli.workflow.admin.process.orderboutique.delete;

import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.service.facade.admin.order.OrderLineAdminService;
import ma.peps.sqli.workflow.admin.process.orderboutique.OrderBoutiqueConstant;
import ma.peps.sqli.zynerator.process.AbstractProcessImpl;
import ma.peps.sqli.zynerator.process.Result;
import org.springframework.transaction.annotation.Transactional;

public class OrderBoutiqueDeleteAdminProcessImpl extends AbstractProcessImpl<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique, OrderBoutiqueDeleteAdminConverter> implements OrderBoutiqueDeleteAdminProcess {

    @Override
    public void init(OrderBoutiqueDeleteAdminInput input, OrderBoutique item) {
        OrderBoutique orderBoutiqueByReference = service.findByReferenceEntity(item);
        if (orderBoutiqueByReference != null) {
            item.setOrderStatus(orderBoutiqueByReference.getOrderStatus());
            item.setId(orderBoutiqueByReference.getId());
        }
    }

    @Override
    public void validate(OrderBoutiqueDeleteAdminInput input, OrderBoutique item, Result<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique> result) {

        if (item.getId() == null) {
            result.addErrorMessage("order.delete.reference.notExist");
        }
        if (item.getOrderStatus() != null && !item.getOrderStatus().getCode().equals(OrderBoutiqueConstant.INITIALISATION_CODE)) {
            result.addErrorMessage("order.delete.orderStatus.notEquals.initialisation");
        }
    }

    @Override
    public void run(OrderBoutiqueDeleteAdminInput input, OrderBoutique t, Result<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique> result) {
        orderLineService.deleteByOrderBoutiqueId(t.getId());
        service.deleteById(t.getId());

    }


    private OrderBoutiqueAdminService service;
    private OrderLineAdminService orderLineService;



    public OrderBoutiqueDeleteAdminProcessImpl(OrderBoutiqueAdminService service, OrderLineAdminService orderLineService, OrderBoutiqueDeleteAdminConverter converter) {
        super(converter);
        this.service = service;
        this.orderLineService = orderLineService;
    }

}
