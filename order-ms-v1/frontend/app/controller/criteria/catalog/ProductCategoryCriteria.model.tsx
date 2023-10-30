import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';


export class ProductCategoryCriteria  extends  BaseCriteria {

    public id: number;

    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;

    constructor() {
        super();
        this.libelle = '';
        this.libelleLike = '';
        this.code = '';
        this.codeLike = '';
    }

}
