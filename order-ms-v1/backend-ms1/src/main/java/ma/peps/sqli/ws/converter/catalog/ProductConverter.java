package  ma.peps.sqli.ws.converter.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.peps.sqli.ws.converter.catalog.ProductCategoryConverter;



import ma.peps.sqli.zynerator.util.StringUtil;
import ma.peps.sqli.zynerator.converter.AbstractConverter;
import ma.peps.sqli.zynerator.util.DateUtil;
import ma.peps.sqli.bean.core.catalog.Product;
import ma.peps.sqli.ws.dto.catalog.ProductDto;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDto> {

    @Autowired
    private ProductCategoryConverter productCategoryConverter ;
    private boolean productCategory;

    public  ProductConverter(){
        super(Product.class, ProductDto.class);
    }

    @Override
    public Product toItem(ProductDto dto) {
        if (dto == null) {
            return null;
        } else {
        Product item = new Product();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.productCategory && dto.getProductCategory()!=null &&  dto.getProductCategory().getId() != null)
                item.setProductCategory(productCategoryConverter.toItem(dto.getProductCategory())) ;




        return item;
        }
    }

    @Override
    public ProductDto toDto(Product item) {
        if (item == null) {
            return null;
        } else {
            ProductDto dto = new ProductDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.productCategory && item.getProductCategory()!=null) {
            dto.setProductCategory(productCategoryConverter.toDto(item.getProductCategory())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.productCategory = value;
    }


    public ProductCategoryConverter getProductCategoryConverter(){
        return this.productCategoryConverter;
    }
    public void setProductCategoryConverter(ProductCategoryConverter productCategoryConverter ){
        this.productCategoryConverter = productCategoryConverter;
    }
    public boolean  isProductCategory(){
        return this.productCategory;
    }
    public void  setProductCategory(boolean productCategory){
        this.productCategory = productCategory;
    }
}
