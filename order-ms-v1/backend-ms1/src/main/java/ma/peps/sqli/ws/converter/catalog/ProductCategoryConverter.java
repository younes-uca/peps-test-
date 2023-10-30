package  ma.peps.sqli.ws.converter.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.peps.sqli.zynerator.util.StringUtil;
import ma.peps.sqli.zynerator.converter.AbstractConverter;
import ma.peps.sqli.zynerator.util.DateUtil;
import ma.peps.sqli.bean.core.catalog.ProductCategory;
import ma.peps.sqli.ws.dto.catalog.ProductCategoryDto;

@Component
public class ProductCategoryConverter extends AbstractConverter<ProductCategory, ProductCategoryDto> {


    public  ProductCategoryConverter(){
        super(ProductCategory.class, ProductCategoryDto.class);
    }

    @Override
    public ProductCategory toItem(ProductCategoryDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProductCategory item = new ProductCategory();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public ProductCategoryDto toDto(ProductCategory item) {
        if (item == null) {
            return null;
        } else {
            ProductCategoryDto dto = new ProductCategoryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
