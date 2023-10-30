package ma.peps.sqli.bean.core.commun;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import ma.peps.sqli.zynerator.audit.AuditBusinessObject;

import java.util.Objects;


@Entity
@Table(name = "order_status")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name = "order_status_seq", sequenceName = "order_status_seq", allocationSize = 1, initialValue = 1)
public class OrderStatus extends AuditBusinessObject {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String style;


    public OrderStatus() {
        super();
    }

    public OrderStatus(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public OrderStatus(String libelle, String code) {
        this.libelle = libelle;
        this.code = code;
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_status_seq")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatus orderStatus = (OrderStatus) o;
        return id != null && id.equals(orderStatus.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

