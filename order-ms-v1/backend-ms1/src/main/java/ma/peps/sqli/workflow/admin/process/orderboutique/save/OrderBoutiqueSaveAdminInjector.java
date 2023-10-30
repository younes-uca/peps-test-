package ma.peps.sqli.workflow.admin.process.orderboutique.save;

import ma.peps.sqli.service.facade.admin.commun.OrderStatusAdminService;
import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBoutiqueSaveAdminInjector {

    @Bean
    public OrderBoutiqueSaveAdminProcess orderBoutiqueSaveAdmin(OrderBoutiqueAdminService service, OrderStatusAdminService orderStatusAdminService, OrderBoutiqueSaveAdminConverter converter) {
        return new OrderBoutiqueSaveAdminProcessImpl(service, orderStatusAdminService, converter);
    }

}
