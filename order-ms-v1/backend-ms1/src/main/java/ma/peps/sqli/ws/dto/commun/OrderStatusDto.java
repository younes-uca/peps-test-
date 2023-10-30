package  ma.peps.sqli.ws.dto.commun;

import ma.peps.sqli.zynerator.audit.Log;
import ma.peps.sqli.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderStatusDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;
    private String style  ;




    public OrderStatusDto(){
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

    @Log
    public String getStyle(){
        return this.style;
    }
    public void setStyle(String style){
        this.style = style;
    }








}
