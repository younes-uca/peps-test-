import {BaseDto} from 'app/zynerator/dto/BaseDto.model';


export class ProductCategoryDto extends BaseDto{

    public libelle: string;

    public code: string;



    constructor() {
        super();
        this.libelle = '';
        this.code = '';
        }

    getClassName() {
        return "Product category";
    }
}
