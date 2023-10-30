package  ma.peps.sqli.dao.criteria.core.order;


import ma.peps.sqli.dao.criteria.core.commun.OrderStatusCriteria;

import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class OrderBoutiqueCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime orderDate;
    private LocalDateTime orderDateFrom;
    private LocalDateTime orderDateTo;
    private String total;
    private String totalMin;
    private String totalMax;

    private OrderStatusCriteria orderStatus ;
    private List<OrderStatusCriteria> orderStatuss ;


    public OrderBoutiqueCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getOrderDate(){
        return this.orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate){
        this.orderDate = orderDate;
    }
    public LocalDateTime getOrderDateFrom(){
        return this.orderDateFrom;
    }
    public void setOrderDateFrom(LocalDateTime orderDateFrom){
        this.orderDateFrom = orderDateFrom;
    }
    public LocalDateTime getOrderDateTo(){
        return this.orderDateTo;
    }
    public void setOrderDateTo(LocalDateTime orderDateTo){
        this.orderDateTo = orderDateTo;
    }
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      

    public OrderStatusCriteria getOrderStatus(){
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatusCriteria orderStatus){
        this.orderStatus = orderStatus;
    }
    public List<OrderStatusCriteria> getOrderStatuss(){
        return this.orderStatuss;
    }

    public void setOrderStatuss(List<OrderStatusCriteria> orderStatuss){
        this.orderStatuss = orderStatuss;
    }
}
