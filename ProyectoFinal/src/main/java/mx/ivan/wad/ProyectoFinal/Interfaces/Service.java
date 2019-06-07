package mx.ivan.wad.ProyectoFinal.Interfaces;

import java.util.List;

import javax.transaction.NotSupportedException;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public interface Service<T> extends Dao<T> {
	
	@Override
	@Transactional
	default void create(T object) {
		// TODO Auto-generated method stub
		getDao().create(object);
	}
	@Override
	@Transactional
	default void delete(int id, Class<T> type) {
		// TODO Auto-generated method stub
		getDao().delete(id, type);
	}
	@Override
	@Transactional
	default T get(int id, Class<T> type) {
		// TODO Auto-generated method stub
		return getDao().get(id, type);
	}
	@Override
	@Transactional
	default List<T> getAll(String entityName) {
		// TODO Auto-generated method stub
		return getDao().getAll(entityName);
	}
	@Override
	@Transactional
	default T getByProperty(String property, String condition, Class<T> type) {
		// TODO Auto-generated method stub
		return getDao().getByProperty(property, condition, type);
	}
	@Override
	@Transactional
	default void update(T object) {
		// TODO Auto-generated method stub
		getDao().update(object);
	}
	
	@Override
	default SessionFactory getSessionFactory() {
		throw new UnsupportedOperationException("Operacion soportada solo si se implementa desde la interface Dao");
	}
	@Override
	default void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operacion soportada solo si se implementa desde la interface Dao");
	}
	
    Dao<T> getDao();
    void setDao(Dao<T> dao);
}

