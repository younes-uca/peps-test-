package  ma.peps.sqli.ws.facade.admin.catalog;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.peps.sqli.bean.core.catalog.ProductCategory;
import ma.peps.sqli.dao.criteria.core.catalog.ProductCategoryCriteria;
import ma.peps.sqli.service.facade.admin.catalog.ProductCategoryAdminService;
import ma.peps.sqli.ws.converter.catalog.ProductCategoryConverter;
import ma.peps.sqli.ws.dto.catalog.ProductCategoryDto;
import ma.peps.sqli.zynerator.controller.AbstractController;
import ma.peps.sqli.zynerator.dto.AuditEntityDto;
import ma.peps.sqli.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.peps.sqli.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.peps.sqli.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/productCategory/")
public class ProductCategoryRestAdmin  extends AbstractController<ProductCategory, ProductCategoryDto, ProductCategoryCriteria, ProductCategoryAdminService, ProductCategoryConverter> {



    @Operation(summary = "upload one productCategory")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple productCategorys")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all productCategorys")
    @GetMapping("")
    public ResponseEntity<List<ProductCategoryDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all productCategorys")
    @GetMapping("optimized")
    public ResponseEntity<List<ProductCategoryDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a productCategory by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ProductCategoryDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  productCategory")
    @PostMapping("")
    public ResponseEntity<ProductCategoryDto> save(@RequestBody ProductCategoryDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  productCategory")
    @PutMapping("")
    public ResponseEntity<ProductCategoryDto> update(@RequestBody ProductCategoryDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of productCategory")
    @PostMapping("multiple")
    public ResponseEntity<List<ProductCategoryDto>> delete(@RequestBody List<ProductCategoryDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified productCategory")
    @DeleteMapping("")
    public ResponseEntity<ProductCategoryDto> delete(@RequestBody ProductCategoryDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified productCategory")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple productCategorys by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds productCategorys by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ProductCategoryDto>> findByCriteria(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated productCategorys by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports productCategorys by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets productCategory data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ProductCategoryCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ProductCategoryRestAdmin (ProductCategoryAdminService service, ProductCategoryConverter converter) {
        super(service, converter);
    }




}
