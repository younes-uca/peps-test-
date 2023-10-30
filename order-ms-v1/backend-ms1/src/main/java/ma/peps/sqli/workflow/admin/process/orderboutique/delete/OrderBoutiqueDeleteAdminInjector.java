package ma.peps.sqli.workflow.admin.process.orderboutique.delete;

import ma.peps.sqli.service.facade.admin.order.OrderBoutiqueAdminService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBoutiqueDeleteAdminInjector {

    @Bean
    public OrderBoutiqueDeleteAdminProcess orderBoutiqueDeleteAdmin(OrderBoutiqueAdminService service, OrderBoutiqueDeleteAdminConverter converter) {
        return new OrderBoutiqueDeleteAdminProcessImpl(service, converter);
    }

}
