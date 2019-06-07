package mx.ivan.wad.ProyectoFinal.Interfaces;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public interface Dao<T> {

    default void create(T object) {
    	getSessionFactory().getCurrentSession().save(object);
    }

    default void delete(int id, Class<T> type) {
        T object = getSessionFactory().getCurrentSession().get(type, id);
        if(object != null)
            getSessionFactory().getCurrentSession().delete(object);
    }

    @SuppressWarnings("unchecked")
	default List<T> getAll(String entityName) {
        return getSessionFactory().getCurrentSession().createQuery("from " + entityName).list();
    }
    

    default T get(int id, Class<T> type) {
        return getSessionFactory().getCurrentSession().find(type, id);
    }


    default T getByProperty(String property, String condition, Class<T> type) {
		Query<T> q = getSessionFactory().getCurrentSession().createQuery("from UserEntity where " + property + " = :condition", type);
//			q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (T) q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
    default void update(T object) {
		// TODO Auto-generated method stub
		T merged = (T)this.getSessionFactory().getCurrentSession().merge(object);
    	this.getSessionFactory().getCurrentSession().saveOrUpdate(merged);
	}
	
    SessionFactory getSessionFactory() throws UnsupportedOperationException;
    void setSessionFactory(SessionFactory sessionFactory) throws UnsupportedOperationException;
}
