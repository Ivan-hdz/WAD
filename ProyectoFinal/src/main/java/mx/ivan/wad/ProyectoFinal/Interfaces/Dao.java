package mx.ivan.wad.ProyectoFinal.Interfaces;

import java.util.List;

import org.hibernate.SessionFactory;

public interface Dao<T> {
    void create(T object);
    void delete(int id);
    List<T> getAll();
    T get(int id);
    T getByProperty(String property, String condition);
    SessionFactory getSessionFactory() throws UnsupportedOperationException;
    void setSessionFactory(SessionFactory sessionFactory) throws UnsupportedOperationException;
}
