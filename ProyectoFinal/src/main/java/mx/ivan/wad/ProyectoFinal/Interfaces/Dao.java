package mx.ivan.wad.ProyectoFinal.Interfaces;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public interface Dao<T> {

    default void create(T object) {
    	getSessionFactory().getCurrentSession().save(object);
    	getSessionFactory().getCurrentSession().flush();
    }

    default void delete(int id, Class<T> type) {
        T object = getSessionFactory().getCurrentSession().get(type, id);
        if(object != null)
            getSessionFactory().getCurrentSession().delete(object);
        getSessionFactory().getCurrentSession().flush();
    }

    @SuppressWarnings("unchecked")
	default List<T> getAll(String entityName) {
        return getSessionFactory().getCurrentSession().createQuery("from " + entityName).list();
    }
    

    default T get(int id, Class<T> type) {
        return getSessionFactory().getCurrentSession().find(type, id);
    }


    default T getOneByProperty(String property, String condition, Class<T> type) {
		Query<T> q = getSessionFactory().getCurrentSession().createQuery("from " + type.getName() + " where " + property + " = :condition", type);
//			q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (T) q.uniqueResult();
	}

    default T getOneByProperty(String property, int condition, Class<T> type) {
		Query<T> q = getSessionFactory().getCurrentSession().createQuery("from " + type.getName() + " where " + property + " = :condition", type);
//			q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (T) q.uniqueResult();
	}
    
    default List<T> getAllByProperty(String property, String condition, Class<T> type) {
		Query<T> q = getSessionFactory().getCurrentSession().createQuery("from " + type.getName() + " where " + property + " = :condition", type);
//			q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (List<T>) q.list();
	}

    default List<T> getAllByProperty(String property, int condition, Class<T> type) {
		Query<T> q = getSessionFactory().getCurrentSession().createQuery("from "+ type.getName() +" where " + property + " = :condition", type);
//			q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (List<T>) q.list();
	}

    
	@SuppressWarnings("unchecked")
    default void update(T object) {
		// TODO Auto-generated method stub
		T merged = (T)this.getSessionFactory().getCurrentSession().merge(object);
    	this.getSessionFactory().getCurrentSession().saveOrUpdate(merged);
    	getSessionFactory().getCurrentSession().flush();
	}
	
    SessionFactory getSessionFactory() throws UnsupportedOperationException;
    void setSessionFactory(SessionFactory sessionFactory) throws UnsupportedOperationException;
}
