package  ma.peps.sqli.dao.criteria.core.order;


import ma.peps.sqli.dao.criteria.core.catalog.ProductCriteria;

import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import java.util.List;

public class OrderLineCriteria extends  BaseCriteria  {

    private String price;
    private String priceMin;
    private String priceMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String quantityReceived;
    private String quantityReceivedMin;
    private String quantityReceivedMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private OrderBoutiqueCriteria orderBoutique ;
    private List<OrderBoutiqueCriteria> orderBoutiques ;


    public OrderLineCriteria(){}

    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }   
    public String getPriceMin(){
        return this.priceMin;
    }
    public void setPriceMin(String priceMin){
        this.priceMin = priceMin;
    }
    public String getPriceMax(){
        return this.priceMax;
    }
    public void setPriceMax(String priceMax){
        this.priceMax = priceMax;
    }
      
    public String getQuantity(){
        return this.quantity;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }   
    public String getQuantityMin(){
        return this.quantityMin;
    }
    public void setQuantityMin(String quantityMin){
        this.quantityMin = quantityMin;
    }
    public String getQuantityMax(){
        return this.quantityMax;
    }
    public void setQuantityMax(String quantityMax){
        this.quantityMax = quantityMax;
    }
      
    public String getQuantityReceived(){
        return this.quantityReceived;
    }
    public void setQuantityReceived(String quantityReceived){
        this.quantityReceived = quantityReceived;
    }   
    public String getQuantityReceivedMin(){
        return this.quantityReceivedMin;
    }
    public void setQuantityReceivedMin(String quantityReceivedMin){
        this.quantityReceivedMin = quantityReceivedMin;
    }
    public String getQuantityReceivedMax(){
        return this.quantityReceivedMax;
    }
    public void setQuantityReceivedMax(String quantityReceivedMax){
        this.quantityReceivedMax = quantityReceivedMax;
    }
      

    public ProductCriteria getProduct(){
        return this.product;
    }

    public void setProduct(ProductCriteria product){
        this.product = product;
    }
    public List<ProductCriteria> getProducts(){
        return this.products;
    }

    public void setProducts(List<ProductCriteria> products){
        this.products = products;
    }
    public OrderBoutiqueCriteria getOrderBoutique(){
        return this.orderBoutique;
    }

    public void setOrderBoutique(OrderBoutiqueCriteria orderBoutique){
        this.orderBoutique = orderBoutique;
    }
    public List<OrderBoutiqueCriteria> getOrderBoutiques(){
        return this.orderBoutiques;
    }

    public void setOrderBoutiques(List<OrderBoutiqueCriteria> orderBoutiques){
        this.orderBoutiques = orderBoutiques;
    }
}
