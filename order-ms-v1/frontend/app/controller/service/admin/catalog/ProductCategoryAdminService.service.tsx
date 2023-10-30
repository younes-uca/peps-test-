import { ADMIN_URL } from 'layout/AppConfig';
import AbstractService from "app/zynerator/service/AbstractService";

import {ProductCategoryDto} from 'app/controller/model/catalog/ProductCategory.model';
import {ProductCategoryCriteria} from 'app/controller/criteria/catalog/ProductCategoryCriteria.model';

export class ProductCategoryAdminService extends AbstractService<ProductCategoryDto, ProductCategoryCriteria>{

    constructor() {
        super(ADMIN_URL , 'productCategory/');
    }

};