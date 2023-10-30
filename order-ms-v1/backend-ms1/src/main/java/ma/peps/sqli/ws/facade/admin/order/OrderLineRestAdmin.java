package  ma.peps.sqli.ws.facade.admin.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.peps.sqli.bean.core.order.OrderLine;
import ma.peps.sqli.dao.criteria.core.order.OrderLineCriteria;
import ma.peps.sqli.service.facade.admin.order.OrderLineAdminService;
import ma.peps.sqli.ws.converter.order.OrderLineConverter;
import ma.peps.sqli.ws.dto.order.OrderLineDto;
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
@RequestMapping("/api/admin/orderLine/")
public class OrderLineRestAdmin  extends AbstractController<OrderLine, OrderLineDto, OrderLineCriteria, OrderLineAdminService, OrderLineConverter> {



    @Operation(summary = "upload one orderLine")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple orderLines")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all orderLines")
    @GetMapping("")
    public ResponseEntity<List<OrderLineDto>> findAll() throws Exception {
        return super.findAll();
    }


    @Operation(summary = "Finds a orderLine by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderLineDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  orderLine")
    @PostMapping("")
    public ResponseEntity<OrderLineDto> save(@RequestBody OrderLineDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  orderLine")
    @PutMapping("")
    public ResponseEntity<OrderLineDto> update(@RequestBody OrderLineDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of orderLine")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderLineDto>> delete(@RequestBody List<OrderLineDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified orderLine")
    @DeleteMapping("")
    public ResponseEntity<OrderLineDto> delete(@RequestBody OrderLineDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified orderLine")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple orderLines by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by product id")
    @GetMapping("product/id/{id}")
    public List<OrderLineDto> findByProductId(@PathVariable Long id){
        return findDtos(service.findByProductId(id));
    }
    @Operation(summary = "delete by product id")
    @DeleteMapping("product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return service.deleteByProductId(id);
    }
    @Operation(summary = "find by orderBoutique id")
    @GetMapping("orderBoutique/id/{id}")
    public List<OrderLineDto> findByOrderBoutiqueId(@PathVariable Long id){
        return findDtos(service.findByOrderBoutiqueId(id));
    }
    @Operation(summary = "delete by orderBoutique id")
    @DeleteMapping("orderBoutique/id/{id}")
    public int deleteByOrderBoutiqueId(@PathVariable Long id){
        return service.deleteByOrderBoutiqueId(id);
    }
    @Operation(summary = "Finds orderLines by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderLineDto>> findByCriteria(@RequestBody OrderLineCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated orderLines by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderLineCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports orderLines by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderLineCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets orderLine data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderLineCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public OrderLineRestAdmin (OrderLineAdminService service, OrderLineConverter converter) {
        super(service, converter);
    }




}
