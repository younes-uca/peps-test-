import { ADMIN_URL } from 'layout/AppConfig';
import AbstractService from "app/zynerator/service/AbstractService";

import {ProductDto} from 'app/controller/model/catalog/Product.model';
import {ProductCriteria} from 'app/controller/criteria/catalog/ProductCriteria.model';

export class ProductAdminService extends AbstractService<ProductDto, ProductCriteria>{

    constructor() {
        super(ADMIN_URL , 'product/');
    }

};