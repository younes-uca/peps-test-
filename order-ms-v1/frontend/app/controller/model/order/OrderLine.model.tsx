import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {OrderBoutiqueCriteria} from 'app/controller/dto/order/OrderBoutique.model';
import {ProductCriteria} from 'app/controller/dto/catalog/Product.model';

export class OrderLineDto extends BaseDto{

    public price: null | number;

    public quantity: null | number;

    public quantityReceived: null | number;

    public product: ProductDto ;
    public orderBoutique: OrderBoutiqueDto ;


    constructor() {
        super();
        this.price = null;
        this.quantity = null;
        this.quantityReceived = null;
        this.product;
        this.orderBoutique;
        }

    getClassName() {
        return "Order line";
    }
}
