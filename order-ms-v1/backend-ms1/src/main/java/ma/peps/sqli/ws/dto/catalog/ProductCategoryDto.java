package  ma.peps.sqli.ws.dto.catalog;

import ma.peps.sqli.zynerator.audit.Log;
import ma.peps.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCategoryDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;




    public ProductCategoryDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }








}
