import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {OrderBoutiqueCriteria} from 'app/controller/criteria/order/OrderBoutiqueCriteria';
import {ProductCriteria} from 'app/controller/criteria/catalog/ProductCriteria';

export class OrderLineCriteria  extends  BaseCriteria {

    public id: number;

     public price: null | number;
     public priceMin: null | number;
     public priceMax: null | number;
     public quantity: null | number;
     public quantityMin: null | number;
     public quantityMax: null | number;
     public quantityReceived: null | number;
     public quantityReceivedMin: null | number;
     public quantityReceivedMax: null | number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public orderBoutique: OrderBoutiqueCriteria ;
  public orderBoutiques: Array<OrderBoutiqueCriteria> ;

    constructor() {
        super();
        this.price = null;
        this.priceMin = null;
        this.priceMax = null;
        this.quantity = null;
        this.quantityMin = null;
        this.quantityMax = null;
        this.quantityReceived = null;
        this.quantityReceivedMin = null;
        this.quantityReceivedMax = null;
        this.product ;
        this.products = new Array<ProductCriteria>() ;
        this.orderBoutique ;
        this.orderBoutiques = new Array<OrderBoutiqueCriteria>() ;
    }

}
