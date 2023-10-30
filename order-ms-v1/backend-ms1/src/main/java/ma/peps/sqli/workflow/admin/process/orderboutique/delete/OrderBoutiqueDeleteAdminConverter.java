package ma.peps.sqli.workflow.admin.process.orderboutique.delete;

import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.ws.converter.catalog.ProductConverter;
import ma.peps.sqli.ws.converter.commun.OrderStatusConverter;
import ma.peps.sqli.ws.converter.order.OrderLineConverter;
import ma.peps.sqli.zynerator.process.AbstractProcessConverter;
import ma.peps.sqli.zynerator.util.DateUtil;
import ma.peps.sqli.zynerator.util.ListUtil;
import ma.peps.sqli.zynerator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBoutiqueDeleteAdminConverter extends AbstractProcessConverter<OrderBoutiqueDeleteAdminInput, OrderBoutiqueDeleteAdminOutput, OrderBoutique> {

    @Autowired
    private OrderStatusConverter orderStatusConverter;
    @Autowired
    private OrderLineConverter orderLineConverter;
    @Autowired
    private ProductConverter productConverter;
    private boolean orderStatus;
    private boolean orderLines;

    public OrderBoutiqueDeleteAdminConverter() {
        super(OrderBoutique.class, OrderBoutiqueDeleteAdminInput.class, OrderBoutiqueDeleteAdminOutput.class);
    }

    @Override
    public OrderBoutique toItem(OrderBoutiqueDeleteAdminInput input) {
        if (input == null) {
            return null;
        } else {
            OrderBoutique item = new OrderBoutique();
            if (StringUtil.isNotEmpty(input.getId()))
                item.setId(input.getId());
            if (StringUtil.isNotEmpty(input.getReference()))
                item.setReference(input.getReference());
            if (StringUtil.isNotEmpty(input.getOrderDate()))
                item.setOrderDate(DateUtil.stringEnToDate(input.getOrderDate()));
            if (StringUtil.isNotEmpty(input.getTotal()))
                item.setTotal(input.getTotal());
            if (this.orderStatus && input.getOrderStatus() != null)
                item.setOrderStatus(orderStatusConverter.toItem(input.getOrderStatus()));


            if (this.orderLines && ListUtil.isNotEmpty(input.getOrderLines()))
                item.setOrderLines(orderLineConverter.toItem(input.getOrderLines()));

            return item;
        }
    }

    @Override
    public OrderBoutiqueDeleteAdminOutput toOutput(OrderBoutique item) {
        if (item == null) {
            return null;
        } else {
            OrderBoutiqueDeleteAdminOutput output = new OrderBoutiqueDeleteAdminOutput();
            if (StringUtil.isNotEmpty(item.getId()))
                output.setId(item.getId());
            if (StringUtil.isNotEmpty(item.getReference()))
                output.setReference(item.getReference());
            if (item.getOrderDate() != null)
                output.setOrderDate(DateUtil.dateTimeToString(item.getOrderDate()));
            if (StringUtil.isNotEmpty(item.getTotal()))
                output.setTotal(item.getTotal());
            if (this.orderStatus && item.getOrderStatus() != null) {
                output.setOrderStatus(orderStatusConverter.toDto(item.getOrderStatus()));
            }
            if (this.orderLines && ListUtil.isNotEmpty(item.getOrderLines())) {
                orderLineConverter.init(true);
                orderLineConverter.setOrderBoutique(false);
                output.setOrderLines(orderLineConverter.toDto(item.getOrderLines()));
                orderLineConverter.setOrderBoutique(true);

            }
            return output;
        }
    }

    public void initList(boolean value) {
        this.orderLines = value;
    }

    public void initObject(boolean value) {
        this.orderStatus = value;
    }


    public OrderStatusConverter getOrderStatusConverter() {
        return this.orderStatusConverter;
    }

    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter) {
        this.orderStatusConverter = orderStatusConverter;
    }

    public OrderLineConverter getOrderLineConverter() {
        return this.orderLineConverter;
    }

    public void setOrderLineConverter(OrderLineConverter orderLineConverter) {
        this.orderLineConverter = orderLineConverter;
    }

    public ProductConverter getProductConverter() {
        return this.productConverter;
    }

    public void setProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }


    public boolean isOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isOrderLines() {
        return this.orderLines;
    }

    public void setOrderLines(boolean orderLines) {
        this.orderLines = orderLines;
    }
}
