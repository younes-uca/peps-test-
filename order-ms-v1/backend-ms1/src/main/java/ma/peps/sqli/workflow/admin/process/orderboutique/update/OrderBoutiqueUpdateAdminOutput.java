package ma.peps.sqli.workflow.admin.process.orderboutique.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.peps.sqli.ws.dto.commun.OrderStatusDto;
import ma.peps.sqli.ws.dto.order.OrderLineDto;
import ma.peps.sqli.zynerator.audit.Log;
import ma.peps.sqli.zynerator.process.AbstractProcessOutput;

import java.math.BigDecimal;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderBoutiqueUpdateAdminOutput extends AbstractProcessOutput {

    private String reference;
    private String orderDate;
    private BigDecimal total;

    private OrderStatusDto orderStatus;

    private List<OrderLineDto> orderLines;


    @Log
    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Log
    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    public OrderStatusDto getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatusDto orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderLineDto> getOrderLines() {
        return this.orderLines;
    }

    public void setOrderLines(List<OrderLineDto> orderLines) {
        this.orderLines = orderLines;
    }
}
