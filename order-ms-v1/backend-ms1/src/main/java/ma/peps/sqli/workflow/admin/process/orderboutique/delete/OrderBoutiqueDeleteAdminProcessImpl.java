package ma.peps.sqli.workflow.admin.process.orderboutique.delete;

import ma.peps.sqli.bean.core.commun.OrderStatus;
import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.service.facade.admin.commun.OrderStatusAdminService;
import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.workflow.admin.process.orderboutique.OrderBoutiqueConstant;
import ma.peps.sqli.workflow.admin.process.orderboutique.save.OrderBoutiqueSaveAdminInput;
import ma.peps.sqli.zynerator.process.AbstractProcessImpl;
import ma.peps.sqli.zynerator.process.Result;

import java.time.LocalDateTime;

public class OrderBoutiqueDeleteAdminProcessImpl extends AbstractProcessImpl<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique, OrderBoutiqueDeleteAdminConverter> implements OrderBoutiqueDeleteAdminProcess {

    @Override
    public void init(OrderBoutiqueDeleteAdminInput input, OrderBoutique item) {
        OrderBoutique byId = service.findById(input.getId());
        if (byId != null) {
            item.setOrderStatus(byId.getOrderStatus());
        }
    }

    @Override
    public void validate(OrderBoutiqueDeleteAdminInput input, OrderBoutique item, Result<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique> result) {
        if (input.getOrderStatus() != null && !input.getOrderStatus().getCode().equals(OrderBoutiqueConstant.INITIALISATION_CODE)) {
            result.addErrorMessage("order.delete.orderStatus.notEquals.initialisation");
        }
    }

    @Override
    public void run(OrderBoutiqueDeleteAdminInput input, OrderBoutique t, Result<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique> result) {
        service.deleteWithAssociatedLists(t);
    }


    private OrderBoutiqueAdminService service;


    public OrderBoutiqueDeleteAdminProcessImpl(OrderBoutiqueAdminService service, OrderBoutiqueDeleteAdminConverter converter) {
        super(converter);
        this.service = service;
    }

}
