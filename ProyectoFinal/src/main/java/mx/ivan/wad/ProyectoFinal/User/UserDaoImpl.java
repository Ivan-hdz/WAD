package mx.ivan.wad.ProyectoFinal.User;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoImpl implements Dao<UserEntity> {
    @Setter
    @Getter
    private SessionFactory sessionFactory;

    @Override
    public void create(UserEntity user) {
        this.getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    public void delete(int userId) {
        UserEntity userEntity = this.getSessionFactory().getCurrentSession().get(UserEntity.class, userId);
        if(userEntity != null)
            this.getSessionFactory().getCurrentSession().delete(userEntity);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> getAll() {
        return this.getSessionFactory().getCurrentSession().createQuery("from UserEntity ").list();
    }
    
    @Override
    public UserEntity get(int id) {
        return this.getSessionFactory().getCurrentSession().find(UserEntity.class, id);
    }

}
