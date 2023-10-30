import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';

import {ProductCategoryCriteria} from 'app/controller/criteria/catalog/ProductCategoryCriteria';

export class ProductCriteria  extends  BaseCriteria {

    public id: number;

    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;
  public productCategory: ProductCategoryCriteria ;
  public productCategorys: Array<ProductCategoryCriteria> ;

    constructor() {
        super();
        this.libelle = '';
        this.libelleLike = '';
        this.code = '';
        this.codeLike = '';
        this.productCategory ;
        this.productCategorys = new Array<ProductCategoryCriteria>() ;
    }

}
