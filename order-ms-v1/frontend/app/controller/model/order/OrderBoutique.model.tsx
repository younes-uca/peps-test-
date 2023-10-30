import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {OrderStatusCriteria} from 'app/controller/dto/commun/OrderStatus.model';

export class OrderBoutiqueDto extends BaseDto{

    public reference: string;

   public orderDate: Date;

    public total: null | number;

    public orderStatus: OrderStatusDto ;
     public orderLines: Array<OrderLineDto>;


    constructor() {
        super();
        this.reference = '';
        this.orderDate = null;
        this.total = null;
        this.orderStatus;
        this.orderLines = new Array<OrderLineDto>();
        }

    getClassName() {
        return "Order boutique";
    }
}
