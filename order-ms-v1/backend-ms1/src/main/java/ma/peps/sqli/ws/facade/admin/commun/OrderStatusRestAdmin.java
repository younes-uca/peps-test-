package  ma.peps.sqli.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.peps.sqli.bean.core.commun.OrderStatus;
import ma.peps.sqli.dao.criteria.core.commun.OrderStatusCriteria;
import ma.peps.sqli.service.facade.admin.commun.OrderStatusAdminService;
import ma.peps.sqli.ws.converter.commun.OrderStatusConverter;
import ma.peps.sqli.ws.dto.commun.OrderStatusDto;
import ma.peps.sqli.zynerator.controller.AbstractController;
import ma.peps.sqli.zynerator.dto.AuditEntityDto;
import ma.peps.sqli.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.peps.sqli.zynerator.process.Result;

import org.springframework.http.HttpEntity;

import org.springframework.web.multipart.MultipartFile;
import ma.peps.sqli.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/orderStatus/")
public class OrderStatusRestAdmin  extends AbstractController<OrderStatus, OrderStatusDto, OrderStatusCriteria, OrderStatusAdminService, OrderStatusConverter> {



    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OrderStatusDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one orderStatus")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple orderStatuss")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all orderStatuss")
    @GetMapping("")
    public ResponseEntity<List<OrderStatusDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all orderStatuss")
    @GetMapping("optimized")
    public ResponseEntity<List<OrderStatusDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a orderStatus by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderStatusDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  orderStatus")
    @PostMapping("")
    public ResponseEntity<OrderStatusDto> save(@RequestBody OrderStatusDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  orderStatus")
    @PutMapping("")
    public ResponseEntity<OrderStatusDto> update(@RequestBody OrderStatusDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of orderStatus")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderStatusDto>> delete(@RequestBody List<OrderStatusDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified orderStatus")
    @DeleteMapping("")
    public ResponseEntity<OrderStatusDto> delete(@RequestBody OrderStatusDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified orderStatus")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple orderStatuss by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "Finds orderStatuss by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderStatusDto>> findByCriteria(@RequestBody OrderStatusCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated orderStatuss by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderStatusCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports orderStatuss by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderStatusCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets orderStatus data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderStatusCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public OrderStatusRestAdmin (OrderStatusAdminService service, OrderStatusConverter converter) {
        super(service, converter);
    }




}
