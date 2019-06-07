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
    
    private SessionFactory sessionFactory;

  

	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}

	
}	