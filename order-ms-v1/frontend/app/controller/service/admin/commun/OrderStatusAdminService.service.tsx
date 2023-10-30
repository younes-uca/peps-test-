import { ADMIN_URL } from 'layout/AppConfig';
import AbstractService from "app/zynerator/service/AbstractService";

import {OrderStatusDto} from 'app/controller/model/commun/OrderStatus.model';
import {OrderStatusCriteria} from 'app/controller/criteria/commun/OrderStatusCriteria.model';

export class OrderStatusAdminService extends AbstractService<OrderStatusDto, OrderStatusCriteria>{

    constructor() {
        super(ADMIN_URL , 'orderStatus/');
    }

};