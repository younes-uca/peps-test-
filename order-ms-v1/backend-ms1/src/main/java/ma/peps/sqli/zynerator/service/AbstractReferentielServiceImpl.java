package ma.peps.sqli.zynerator.service;

import ma.peps.sqli.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.peps.sqli.zynerator.criteria.BaseCriteria;
import ma.peps.sqli.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
