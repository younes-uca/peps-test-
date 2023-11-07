package ma.peps.sqli.service.history.facade;

import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.ws.dto.order.OrderBoutiqueDto;
import ma.peps.sqli.zynerator.enumeration.ACTION_TYPE;

public interface OrderBoutiqueHistoryService {

    void save(OrderBoutiqueDto dto, ACTION_TYPE action);

    void save(OrderBoutique t, ACTION_TYPE action);

    void save(String dataAsJson, Long id, ACTION_TYPE action);
}
