package ma.peps.sqli.bean.core.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import ma.peps.sqli.bean.core.commun.OrderStatus;
import ma.peps.sqli.zynerator.audit.AuditBusinessObject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "order_boutique")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name = "order_boutique_seq", sequenceName = "order_boutique_seq", allocationSize = 1, initialValue = 1)
public class OrderBoutique extends AuditBusinessObject {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime orderDate;
    private BigDecimal total = BigDecimal.ZERO;

    private OrderStatus orderStatus;

    private List<OrderLine> orderLines;

    public OrderBoutique() {
        super();
    }

    public OrderBoutique(String reference) {
        this.reference = reference;
    }

    public OrderBoutique(Long id, String reference) {
        this.id = id;
        this.reference = reference;
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_boutique_seq")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @OneToMany(mappedBy = "orderBoutique")

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBoutique orderBoutique = (OrderBoutique) o;
        return id != null && id.equals(orderBoutique.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

