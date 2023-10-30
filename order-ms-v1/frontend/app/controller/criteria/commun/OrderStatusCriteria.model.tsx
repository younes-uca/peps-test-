import {BaseCriteria} from 'app/zynerator/criteria/BaseCriteria.model';


export class OrderStatusCriteria  extends  BaseCriteria {

    public id: number;

    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;
    public style: string;
    public styleLike: string;

    constructor() {
        super();
        this.libelle = '';
        this.libelleLike = '';
        this.code = '';
        this.codeLike = '';
        this.style = '';
        this.styleLike = '';
    }

}
