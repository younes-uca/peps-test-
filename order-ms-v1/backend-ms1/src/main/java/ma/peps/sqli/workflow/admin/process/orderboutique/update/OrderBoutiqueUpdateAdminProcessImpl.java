package ma.peps.sqli.workflow.admin.process.orderboutique.update;

import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.zynerator.process.AbstractProcessImpl;
import ma.peps.sqli.zynerator.process.Result;

public class OrderBoutiqueUpdateAdminProcessImpl extends AbstractProcessImpl<OrderBoutiqueUpdateAdminInput, OrderBoutiqueUpdateAdminOutput, OrderBoutique, OrderBoutiqueUpdateAdminConverter> implements OrderBoutiqueUpdateAdminProcess {

    @Override
    public void init(OrderBoutiqueUpdateAdminInput input, OrderBoutique item) {
    }

    @Override
    public void validate(OrderBoutiqueUpdateAdminInput input, OrderBoutique item, Result<OrderBoutiqueUpdateAdminInput, OrderBoutiqueUpdateAdminOutput, OrderBoutique> result) {
    }

    @Override
    public void run(OrderBoutiqueUpdateAdminInput input, OrderBoutique t, Result<OrderBoutiqueUpdateAdminInput, OrderBoutiqueUpdateAdminOutput, OrderBoutique> result) {

    }


    private OrderBoutiqueAdminService service;

    public OrderBoutiqueUpdateAdminProcessImpl(OrderBoutiqueAdminService service, OrderBoutiqueUpdateAdminConverter converter) {
        super(converter);
        this.service = service;
    }

}
