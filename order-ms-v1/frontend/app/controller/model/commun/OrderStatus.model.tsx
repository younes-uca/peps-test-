import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class OrderStatusDto extends BaseDto{

    public libelle: string;

    public code: string;

    public style: string;



    constructor() {
        super();
        this.libelle = '';
        this.code = '';
        this.style = '';
        }

    getClassName() {
        return "Order status";
    }
}
