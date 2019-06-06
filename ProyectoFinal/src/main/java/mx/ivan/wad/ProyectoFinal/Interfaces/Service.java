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
	default void delete(int id) {
		// TODO Auto-generated method stub
		getDao().delete(id);
	}
	@Override
	@Transactional
	default T get(int id) {
		// TODO Auto-generated method stub
		return getDao().get(id);
	}
	@Override
	@Transactional
	default List<T> getAll() {
		// TODO Auto-generated method stub
		return getDao().getAll();
	}
	@Override
	@Transactional
	default T getByProperty(String property, String condition) {
		// TODO Auto-generated method stub
		return getDao().getByProperty(property, condition);
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

