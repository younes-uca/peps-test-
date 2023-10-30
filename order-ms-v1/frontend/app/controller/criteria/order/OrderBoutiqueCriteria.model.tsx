import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {OrderStatusCriteria} from 'app/controller/criteria/commun/OrderStatusCriteria';

export class OrderBoutiqueCriteria  extends  BaseCriteria {

    public id: number;

    public reference: string;
    public referenceLike: string;
    public orderDate: Date;
    public orderDateFrom: Date;
    public orderDateTo: Date;
     public total: null | number;
     public totalMin: null | number;
     public totalMax: null | number;
  public orderStatus: OrderStatusCriteria ;
  public orderStatuss: Array<OrderStatusCriteria> ;
      public orderLines: Array<OrderLineCriteria>;

    constructor() {
        super();
        this.reference = '';
        this.referenceLike = '';
        this.orderDate = null;
        this.orderDateFrom  = null;
        this.orderDateTo = null;
        this.total = null;
        this.totalMin = null;
        this.totalMax = null;
        this.orderStatus ;
        this.orderStatuss = new Array<OrderStatusCriteria>() ;
    }

}
