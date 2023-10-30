package  ma.peps.sqli.ws.dto.order;

import ma.peps.sqli.zynerator.audit.Log;
import ma.peps.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.peps.sqli.ws.dto.catalog.ProductDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderLineDto  extends AuditBaseDto {

    private BigDecimal price  ;
    private BigDecimal quantity  ;
    private BigDecimal quantityReceived  ;

    private ProductDto product ;
    private OrderBoutiqueDto orderBoutique ;



    public OrderLineDto(){
        super();
    }



    @Log
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    @Log
    public BigDecimal getQuantityReceived(){
        return this.quantityReceived;
    }
    public void setQuantityReceived(BigDecimal quantityReceived){
        this.quantityReceived = quantityReceived;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public OrderBoutiqueDto getOrderBoutique(){
        return this.orderBoutique;
    }

    public void setOrderBoutique(OrderBoutiqueDto orderBoutique){
        this.orderBoutique = orderBoutique;
    }






}
