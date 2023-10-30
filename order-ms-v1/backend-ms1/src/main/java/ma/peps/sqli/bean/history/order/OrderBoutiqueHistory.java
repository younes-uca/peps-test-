package ma.peps.sqli.bean.history.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.peps.sqli.zynerator.history.HistBusinessObject;
import jakarta.persistence.*;


@Entity
@Table(name = "order_boutique")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_boutique_seq",sequenceName="order_boutique_seq",allocationSize=1, initialValue = 1)
public class OrderBoutiqueHistory extends HistBusinessObject  {


    public OrderBoutiqueHistory() {
    super();
    }

    public OrderBoutiqueHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_boutique_seq")
    public Long getId() {
    return id;
    }
}

