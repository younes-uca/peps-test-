package  ma.peps.sqli.ws.facade.admin.catalog;

import io.swagger.v3.oas.annotations.Operation;

import ma.peps.sqli.bean.core.catalog.Product;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCriteria;
import ma.peps.sqli.service.core.facade.admin.catalog.ProductAdminService;
import ma.peps.sqli.ws.converter.catalog.ProductConverter;
import ma.peps.sqli.ws.dto.catalog.ProductDto;
import ma.peps.sqli.zynerator.controller.AbstractController;
import ma.peps.sqli.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import org.springframework.web.multipart.MultipartFile;
import ma.peps.sqli.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/product/")
public class ProductRestAdmin  extends AbstractController<Product, ProductDto, ProductCriteria, ProductAdminService, ProductConverter> {



    @Operation(summary = "upload one product")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple products")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all products")
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all products")
    @GetMapping("optimized")
    public ResponseEntity<List<ProductDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a product by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  product")
    @PostMapping("")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  product")
    @PutMapping("")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of product")
    @PostMapping("multiple")
    public ResponseEntity<List<ProductDto>> delete(@RequestBody List<ProductDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified product")
    @DeleteMapping("")
    public ResponseEntity<ProductDto> delete(@RequestBody ProductDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified product")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple products by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by productCategory id")
    @GetMapping("productCategory/id/{id}")
    public List<ProductDto> findByProductCategoryId(@PathVariable Long id){
        return findDtos(service.findByProductCategoryId(id));
    }
    @Operation(summary = "delete by productCategory id")
    @DeleteMapping("productCategory/id/{id}")
    public int deleteByProductCategoryId(@PathVariable Long id){
        return service.deleteByProductCategoryId(id);
    }
    @Operation(summary = "Finds products by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProductDto>> findByCriteria(@RequestBody ProductCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated products by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProductCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports products by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProductCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets product data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProductCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProductRestAdmin (ProductAdminService service, ProductConverter converter) {
        super(service, converter);
    }




}
