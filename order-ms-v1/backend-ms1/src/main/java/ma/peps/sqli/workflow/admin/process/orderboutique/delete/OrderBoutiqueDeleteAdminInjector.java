package ma.peps.sqli.workflow.admin.process.orderboutique.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.peps.sqli.service.core.facade.admin.order.OrderBoutiqueAdminService;
import ma.peps.sqli.service.core.facade.admin.order.OrderLineAdminService;
import ma.peps.sqli.service.history.facade.OrderBoutiqueHistoryService;
import ma.peps.sqli.ws.converter.order.OrderBoutiqueConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBoutiqueDeleteAdminInjector {


    @Bean
    public OrderBoutiqueDeleteAdminProcess orderBoutiqueDeleteAdmin(OrderBoutiqueAdminService service, OrderBoutiqueHistoryService history, OrderLineAdminService orderLineService, OrderBoutiqueDeleteAdminConverter converter, OrderBoutiqueConverter orderBoutiqueConverter) {
        OrderBoutiqueDeleteAdminProcessImpl orderBoutiqueDeleteAdminProcess = new OrderBoutiqueDeleteAdminProcessImpl(service, orderLineService, history, converter,orderBoutiqueConverter);
        return orderBoutiqueDeleteAdminProcess;
    }

}
