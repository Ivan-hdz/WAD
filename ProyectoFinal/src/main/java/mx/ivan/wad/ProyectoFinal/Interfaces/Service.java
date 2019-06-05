package mx.ivan.wad.ProyectoFinal.Interfaces;

import java.util.List;

public interface Service<T>  {
    void create(T object);
    void delete(int id);
    T get(int id);
    List<T> getAll();
    T getByProperty(String property, String condition);
}

