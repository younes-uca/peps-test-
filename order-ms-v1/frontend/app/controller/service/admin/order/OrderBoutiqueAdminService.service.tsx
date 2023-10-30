import { ADMIN_URL } from 'layout/AppConfig';
import AbstractService from "app/zynerator/service/AbstractService";

import {OrderBoutiqueDto} from 'app/controller/model/order/OrderBoutique.model';
import {OrderBoutiqueCriteria} from 'app/controller/criteria/order/OrderBoutiqueCriteria.model';

export class OrderBoutiqueAdminService extends AbstractService<OrderBoutiqueDto, OrderBoutiqueCriteria>{

    constructor() {
        super(ADMIN_URL , 'orderBoutique/');
    }

};