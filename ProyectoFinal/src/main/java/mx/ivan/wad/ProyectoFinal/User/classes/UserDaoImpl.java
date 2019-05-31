package mx.ivan.wad.ProyectoFinal.User.classes;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import mx.ivan.wad.ProyectoFinal.User.interfaces.UserDao;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Setter
    @Getter
    private SessionFactory sessionFactory;

    @Override
    public void createUser(UserEntity user) {
        this.getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(int userId) {
        UserEntity userEntity = this.getSessionFactory().getCurrentSession().get(UserEntity.class, userId);
        if(userEntity != null)
            this.getSessionFactory().getCurrentSession().delete(userEntity);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> listUsers() {
        return this.getSessionFactory().getCurrentSession().createQuery("from UserEntity ").list();
    }

}
