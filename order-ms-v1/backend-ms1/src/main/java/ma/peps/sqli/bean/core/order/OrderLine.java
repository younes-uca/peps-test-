package ma.peps.sqli.bean.core.order;

import java.util.Objects;





import ma.peps.sqli.bean.core.catalog.Product;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.peps.sqli.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "order_line")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_line_seq",sequenceName="order_line_seq",allocationSize=1, initialValue = 1)
public class OrderLine   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal quantityReceived = BigDecimal.ZERO;

    private Product product ;
    private OrderBoutique orderBoutique ;


    public OrderLine(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="order_line_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    public BigDecimal getQuantityReceived(){
        return this.quantityReceived;
    }
    public void setQuantityReceived(BigDecimal quantityReceived){
        this.quantityReceived = quantityReceived;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderBoutique getOrderBoutique(){
        return this.orderBoutique;
    }
    public void setOrderBoutique(OrderBoutique orderBoutique){
        this.orderBoutique = orderBoutique;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return id != null && id.equals(orderLine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

