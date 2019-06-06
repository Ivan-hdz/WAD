package mx.ivan.wad.ProyectoFinal.User;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements Service<UserEntity> {
    
    private Dao<UserEntity> userDao;


	@Override
	public Dao<UserEntity> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	@Override
	public void setDao(Dao<UserEntity> dao) {
		// TODO Auto-generated method stub
		userDao = dao;
	}

}
