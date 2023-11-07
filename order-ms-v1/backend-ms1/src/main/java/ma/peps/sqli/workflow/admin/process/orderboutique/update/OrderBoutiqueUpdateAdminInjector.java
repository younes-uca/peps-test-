package ma.peps.sqli.workflow.admin.process.orderboutique.update;

import ma.peps.sqli.service.core.facade.admin.order.OrderBoutiqueAdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBoutiqueUpdateAdminInjector {

    @Bean
    public OrderBoutiqueUpdateAdminProcess orderBoutiqueUpdateAdmin(OrderBoutiqueAdminService service, OrderBoutiqueUpdateAdminConverter converter) {
        return new OrderBoutiqueUpdateAdminProcessImpl(service, converter);
    }

}
