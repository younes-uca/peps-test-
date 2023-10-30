package  ma.peps.sqli.ws.converter.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.peps.sqli.ws.converter.order.OrderBoutiqueConverter;
import ma.peps.sqli.ws.converter.catalog.ProductConverter;

import ma.peps.sqli.bean.core.order.OrderBoutique;


import ma.peps.sqli.zynerator.util.StringUtil;
import ma.peps.sqli.zynerator.converter.AbstractConverter;
import ma.peps.sqli.zynerator.util.DateUtil;
import ma.peps.sqli.bean.core.order.OrderLine;
import ma.peps.sqli.ws.dto.order.OrderLineDto;

@Component
public class OrderLineConverter extends AbstractConverter<OrderLine, OrderLineDto> {

    @Autowired
    private OrderBoutiqueConverter orderBoutiqueConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean orderBoutique;

    public  OrderLineConverter(){
        super(OrderLine.class, OrderLineDto.class);
    }

    @Override
    public OrderLine toItem(OrderLineDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderLine item = new OrderLine();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getQuantityReceived()))
                item.setQuantityReceived(dto.getQuantityReceived());
            if(this.product && dto.getProduct()!=null &&  dto.getProduct().getId() != null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getOrderBoutique() != null && dto.getOrderBoutique().getId() != null){
                item.setOrderBoutique(new OrderBoutique());
                item.getOrderBoutique().setId(dto.getOrderBoutique().getId());
                item.getOrderBoutique().setReference(dto.getOrderBoutique().getReference());
            }




        return item;
        }
    }

    @Override
    public OrderLineDto toDto(OrderLine item) {
        if (item == null) {
            return null;
        } else {
            OrderLineDto dto = new OrderLineDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getQuantityReceived()))
                dto.setQuantityReceived(item.getQuantityReceived());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.orderBoutique && item.getOrderBoutique()!=null) {
            dto.setOrderBoutique(orderBoutiqueConverter.toDto(item.getOrderBoutique())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.orderBoutique = value;
    }


    public OrderBoutiqueConverter getOrderBoutiqueConverter(){
        return this.orderBoutiqueConverter;
    }
    public void setOrderBoutiqueConverter(OrderBoutiqueConverter orderBoutiqueConverter ){
        this.orderBoutiqueConverter = orderBoutiqueConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isOrderBoutique(){
        return this.orderBoutique;
    }
    public void  setOrderBoutique(boolean orderBoutique){
        this.orderBoutique = orderBoutique;
    }
}
