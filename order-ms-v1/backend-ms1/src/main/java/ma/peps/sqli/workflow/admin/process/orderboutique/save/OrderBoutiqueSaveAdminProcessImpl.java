package ma.peps.sqli.workflow.admin.process.orderboutique.save;

import ma.peps.sqli.bean.core.commun.OrderStatus;
import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.bean.core.order.OrderLine;
import ma.peps.sqli.service.facade.admin.commun.OrderStatusAdminService;
import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.workflow.admin.process.orderboutique.OrderBoutiqueConstant;
import ma.peps.sqli.zynerator.process.AbstractProcessImpl;
import ma.peps.sqli.zynerator.process.Result;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderBoutiqueSaveAdminProcessImpl extends AbstractProcessImpl<OrderBoutiqueSaveAdminInput, OrderBoutiqueSaveAdminOutput, OrderBoutique, OrderBoutiqueSaveAdminConverter> implements OrderBoutiqueSaveAdminProcess {


    @Override
    public void init(OrderBoutiqueSaveAdminInput input, OrderBoutique item) {
        item.setOrderDate(LocalDateTime.now());
        OrderStatus orderStatus = orderStatusAdminService.findOrSave(new OrderStatus(OrderBoutiqueConstant.INITIALISATION_LABEL, OrderBoutiqueConstant.INITIALISATION_CODE));
        item.setOrderStatus(orderStatus);
    }

    @Override
    public void validate(OrderBoutiqueSaveAdminInput input, OrderBoutique item, Result<OrderBoutiqueSaveAdminInput, OrderBoutiqueSaveAdminOutput, OrderBoutique> result) {
        if (input.getOrderLines() == null || input.getOrderLines().isEmpty()) {
            result.addErrorMessage("order.save.orderlines.empty");
        }
    }

    @Override
    public void run(OrderBoutiqueSaveAdminInput input, OrderBoutique t, Result<OrderBoutiqueSaveAdminInput, OrderBoutiqueSaveAdminOutput, OrderBoutique> result) {
        BigDecimal total = BigDecimal.ZERO;
        List<OrderLine> orderLines = t.getOrderLines();
        if (orderLines != null) {
            for (OrderLine orderLine : orderLines) {
                total = total.add(orderLine.getPrice().multiply(orderLine.getQuantity()));
            }
        }
        t.setTotal(total);
        service.create(t);
    }


    private OrderBoutiqueAdminService service;
    private OrderStatusAdminService orderStatusAdminService;

    public OrderBoutiqueSaveAdminProcessImpl(OrderBoutiqueAdminService service, OrderStatusAdminService orderStatusAdminService, OrderBoutiqueSaveAdminConverter converter) {
        super(converter);
        this.service = service;
        this.orderStatusAdminService = orderStatusAdminService;
    }

}
