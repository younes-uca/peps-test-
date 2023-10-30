import { ADMIN_URL } from 'layout/AppConfig';
import AbstractService from "app/zynerator/service/AbstractService";

import {OrderLineDto} from 'app/controller/model/order/OrderLine.model';
import {OrderLineCriteria} from 'app/controller/criteria/order/OrderLineCriteria.model';

export class OrderLineAdminService extends AbstractService<OrderLineDto, OrderLineCriteria>{

    constructor() {
        super(ADMIN_URL , 'orderLine/');
    }

};