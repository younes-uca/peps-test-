package ma.peps.sqli.zynerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.peps.sqli.zynerator.audit.AuditBusinessObject;
import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import ma.peps.sqli.zynerator.dto.AuditEntityDto;
import ma.peps.sqli.zynerator.dto.BaseDto;
import ma.peps.sqli.zynerator.enumeration.ACTION_TYPE;
import ma.peps.sqli.zynerator.exception.EntityNotFoundException;
import ma.peps.sqli.zynerator.history.HistBusinessObject;
import ma.peps.sqli.zynerator.history.HistCriteria;
import ma.peps.sqli.zynerator.repository.AbstractHistoryRepository;
import ma.peps.sqli.zynerator.security.bean.User;
import ma.peps.sqli.zynerator.security.service.facade.UserService;
import ma.peps.sqli.zynerator.specification.AbstractHistorySpecification;
import ma.peps.sqli.zynerator.util.RefelexivityUtil;
import ma.peps.sqli.zynerator.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


public abstract class AbstractServiceHistoryImpl<H extends HistBusinessObject, DTO extends BaseDto, T extends AuditBusinessObject, HC extends HistCriteria, HISTREPO extends AbstractHistoryRepository<H, Long>, SERV extends IService<T, ?>> {


    protected HISTREPO historyRepository;
    protected SERV service;

    protected Class<H> historyClass;
    protected Class<HC> historyCriteriaClass;
    protected Class<T> itemClass;
    protected Class<? extends AbstractHistorySpecification<HC, H>> historySPecificationClass;


    @Autowired
    protected UserService userService;
    @Autowired
    protected ObjectMapper objectMapper;


    public AbstractServiceHistoryImpl(HISTREPO historyRepository, SERV service) {
        this.historyRepository = historyRepository;
        this.service = service;
        this.configure();
    }


    public void deleteById(Long id) {
        historyRepository.deleteById(id);
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }

    public void save(DTO dto, ACTION_TYPE action) {
        try {
            String dtoAsJson = objectMapper.writeValueAsString(dto);
            save(dtoAsJson, dto.getId(), action);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(T t, ACTION_TYPE action) {
        try {
            if (t != null) {
                String dtoAsJson = objectMapper.writeValueAsString(t);
                save(dtoAsJson, t.getId(), action);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(String dataAsJson, Long id, ACTION_TYPE action) {
        User currentUser = getCurrentUser();
        H history = RefelexivityUtil.constructObjectUsingDefaultConstr(historyClass);
        history.setActionType(action.name());
        history.setObjectName(itemClass.getSimpleName());
        history.setObjectId(id);
        /*history.setUserId(currentUser.getId());
        history.setUsername(currentUser.getUsername());*/
        history.setData(dataAsJson);
        history.setDateHistory(LocalDateTime.now());
        historyRepository.save(history);
    }


    public AuditEntityDto findHistoryById(Long id) {
        H h = historyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("errors.notFound", new String[]{historyClass.getSimpleName(), id.toString()}));
        return null;
        //TODO: restore this ==> return (AuditEntityDto) abstractConverter.copyFromHistory(h);
    }


    public List<AuditEntityDto> findHistoryPaginatedByCriteria(HC historyCriteria, int page, int pageSize, String order, String sortField) {
        AbstractHistorySpecification<HC, H> mySpecification = constructSpecificationHistory(historyCriteria);
        order = StringUtil.isNotEmpty(order) ? order : "desc";
        sortField = StringUtil.isNotEmpty(sortField) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        List<H> content = historyRepository.findAll(mySpecification, pageable).getContent();
        return null;
        //TODO: restore this ==> return content.stream().map(h -> (AuditEntityDto) abstractConverter.copyFromHistory(h)).collect(Collectors.toList());
    }

    public List<AuditEntityDto> findHistoryByCriteria(HC historyCriteria) {
        AbstractHistorySpecification<HC, H> mySpecification = constructSpecificationHistory(historyCriteria);
        List<H> content = null;
        if (historyCriteria.isPeagable()) {
            Pageable pageable = PageRequest.of(0, historyCriteria.getMaxResults());
            content = historyRepository.findAll(mySpecification, pageable).getContent();
        } else {
            content = historyRepository.findAll(mySpecification);
        }
        return null;
        //TODO: restore this ==> return content.stream().map(h -> (AuditEntityDto) abstractConverter.copyFromHistory(h)).collect(Collectors.toList());
    }

    public int getHistoryDataSize(HC historyCriteria) {
        AbstractHistorySpecification<HC, H> mySpecification = constructSpecificationHistory(historyCriteria);
        mySpecification.setDistinct(true);
        return ((Long) historyRepository.count(mySpecification)).intValue();
    }

    private AbstractHistorySpecification<HC, H> constructSpecificationHistory(HC hc) {
        AbstractHistorySpecification<HC, H> mySpecification = RefelexivityUtil.constructObjectUsingDefaultConstr(historySPecificationClass);
        mySpecification.setCriteria(hc);
        return mySpecification;
    }

    public void configure(Class<H> historyClass, Class<HC> historyCriteriaClass, Class<T> itemClass) {
        this.historyClass = historyClass;
        this.historyCriteriaClass = historyCriteriaClass;
        this.itemClass = itemClass;
    }

    public abstract void configure();


    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && principal instanceof User) {
            return (User) principal;
        } else if (principal != null && principal instanceof String) {
            return userService.findByUsername(principal.toString());
        } else {
            User ana = new User("ana"); // TODO : change this to return null just for test purpose;
            ana.setId(1L);
            return ana;
        }
    }

    public Long getEtablissementId() {
        User currentUser = getCurrentUser();
        Long etablissementId = (currentUser != null && currentUser.getEtablissement() != null) ? currentUser.getEtablissement().getId() : null;
        return etablissementId == null ? 1L : etablissementId; // TODO: if conneceted user is null exception
    }


}
