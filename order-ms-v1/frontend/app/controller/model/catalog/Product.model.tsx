import {BaseDto} from 'app/zynerator/dto/BaseDto.model';

import {ProductCategoryCriteria} from 'app/controller/dto/catalog/ProductCategory.model';

export class ProductDto extends BaseDto{

    public libelle: string;

    public code: string;

    public productCategory: ProductCategoryDto ;


    constructor() {
        super();
        this.libelle = '';
        this.code = '';
        this.productCategory;
        }

    getClassName() {
        return "Product";
    }
}
