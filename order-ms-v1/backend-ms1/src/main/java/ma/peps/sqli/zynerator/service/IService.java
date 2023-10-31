package ma.peps.sqli.zynerator.service;

import ma.peps.sqli.zynerator.bean.BusinessObject;
import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import ma.peps.sqli.zynerator.dto.AuditEntityDto;
import ma.peps.sqli.zynerator.security.bean.User;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface IService<T extends BusinessObject, Criteria extends BaseCriteria> {

    T create(T t);

    T update(T t);

    List<T> update(List<T> ts,boolean createIfNotExist);

    T findById(Long id);

    T findOrSave(T t);

    void findOrSaveAssociatedObject(T t);

    T findByReferenceEntity(T t);

    T findWithAssociatedLists(Long id);

    boolean deleteByReferenceEntityWithAssociatedLists(T t);

    List<T> findByCriteria(Criteria critera);

    List<T> findAllOptimized();

    List<T> findPaginatedByCriteria(Criteria critera, int page, int pageSize, String order, String sortField);

    int getDataSize(Criteria criteria);

    void delete(List<T> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<T>> getToBeSavedAndToBeDeleted(List<T> oldList, List<T> newList);

    User getCurrentUser();

    List<T> importerData(List<T> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<T> importExcel(MultipartFile file);
}
