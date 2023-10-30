package  ma.peps.sqli.dao.criteria.core.catalog;



import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProductCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private ProductCategoryCriteria productCategory ;
    private List<ProductCategoryCriteria> productCategorys ;


    public ProductCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


    public ProductCategoryCriteria getProductCategory(){
        return this.productCategory;
    }

    public void setProductCategory(ProductCategoryCriteria productCategory){
        this.productCategory = productCategory;
    }
    public List<ProductCategoryCriteria> getProductCategorys(){
        return this.productCategorys;
    }

    public void setProductCategorys(List<ProductCategoryCriteria> productCategorys){
        this.productCategorys = productCategorys;
    }
}
