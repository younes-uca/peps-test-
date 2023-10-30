package  ma.peps.sqli.ws.converter.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.peps.sqli.zynerator.util.ListUtil;

import ma.peps.sqli.ws.converter.commun.OrderStatusConverter;
import ma.peps.sqli.ws.converter.order.OrderLineConverter;
import ma.peps.sqli.ws.converter.catalog.ProductConverter;



import ma.peps.sqli.zynerator.util.StringUtil;
import ma.peps.sqli.zynerator.converter.AbstractConverter;
import ma.peps.sqli.zynerator.util.DateUtil;
import ma.peps.sqli.bean.core.order.OrderBoutique;
import ma.peps.sqli.ws.dto.order.OrderBoutiqueDto;

@Component
public class OrderBoutiqueConverter extends AbstractConverter<OrderBoutique, OrderBoutiqueDto> {

    @Autowired
    private OrderStatusConverter orderStatusConverter ;
    @Autowired
    private OrderLineConverter orderLineConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean orderStatus;
    private boolean orderLines;

    public  OrderBoutiqueConverter(){
        super(OrderBoutique.class, OrderBoutiqueDto.class);
        init(true);
    }

    @Override
    public OrderBoutique toItem(OrderBoutiqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderBoutique item = new OrderBoutique();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getOrderDate()))
                item.setOrderDate(DateUtil.stringEnToDate(dto.getOrderDate()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(this.orderStatus && dto.getOrderStatus()!=null &&  dto.getOrderStatus().getId() != null)
                item.setOrderStatus(orderStatusConverter.toItem(dto.getOrderStatus())) ;


            if(this.orderLines && ListUtil.isNotEmpty(dto.getOrderLines()))
                item.setOrderLines(orderLineConverter.toItem(dto.getOrderLines()));


        return item;
        }
    }

    @Override
    public OrderBoutiqueDto toDto(OrderBoutique item) {
        if (item == null) {
            return null;
        } else {
            OrderBoutiqueDto dto = new OrderBoutiqueDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getOrderDate()!=null)
                dto.setOrderDate(DateUtil.dateTimeToString(item.getOrderDate()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
        if(this.orderStatus && item.getOrderStatus()!=null) {
            dto.setOrderStatus(orderStatusConverter.toDto(item.getOrderStatus())) ;
        }
        if(this.orderLines && ListUtil.isNotEmpty(item.getOrderLines())){
            orderLineConverter.init(true);
            orderLineConverter.setOrderBoutique(false);
            dto.setOrderLines(orderLineConverter.toDto(item.getOrderLines()));
            orderLineConverter.setOrderBoutique(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.orderLines = value;
    }

    public void initObject(boolean value) {
        this.orderStatus = value;
    }


    public OrderStatusConverter getOrderStatusConverter(){
        return this.orderStatusConverter;
    }
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter ){
        this.orderStatusConverter = orderStatusConverter;
    }
    public OrderLineConverter getOrderLineConverter(){
        return this.orderLineConverter;
    }
    public void setOrderLineConverter(OrderLineConverter orderLineConverter ){
        this.orderLineConverter = orderLineConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isOrderStatus(){
        return this.orderStatus;
    }
    public void  setOrderStatus(boolean orderStatus){
        this.orderStatus = orderStatus;
    }
    public boolean  isOrderLines(){
        return this.orderLines ;
    }
    public void  setOrderLines(boolean orderLines ){
        this.orderLines  = orderLines ;
    }
}
