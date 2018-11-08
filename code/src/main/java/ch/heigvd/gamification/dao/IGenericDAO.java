package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.AbstractDomainModelEntity;

import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 */
@Local
public interface IGenericDAO<T extends AbstractDomainModelEntity, PK> {

    public PK create(T t);

    public T createAndReturnManagedEntity(T t);

    public void update(T t) throws BusinessDomainEntityNotFoundException ;

    public void delete(T t) throws BusinessDomainEntityNotFoundException ;

    public long count();

    public T findById(PK id) throws BusinessDomainEntityNotFoundException ;

    public List<T> findAll();

    public List<T> findAllByPage(int pageSize, int pageIndex);

}
