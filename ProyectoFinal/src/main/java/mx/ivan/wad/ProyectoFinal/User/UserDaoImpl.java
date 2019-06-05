package mx.ivan.wad.ProyectoFinal.User;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

import org.hibernate.query.Query;

import com.opensymphony.xwork2.Action;

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

	@Override
	public UserEntity getByProperty(String property, String condition) {
		Query<UserEntity> q = this.getSessionFactory().getCurrentSession().createQuery("from UserEntity where " + property + " = :condition", UserEntity.class);
//		q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (UserEntity) q.uniqueResult();
	}
	
}	