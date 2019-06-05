package mx.ivan.wad.ProyectoFinal.User;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements Service<UserEntity> {
    @Setter
    @Getter
    private Dao<UserEntity> userDao;

    @Transactional
    @Override
    public void create(UserEntity user) {
        this.userDao.create(user);
    }

    @Transactional
    @Override
    public void delete(int userId) {
        this.userDao.delete(userId);
    }

    @Transactional
    @Override
    public List<UserEntity> getAll() {
        return this.userDao.getAll();
    }
    
    @Transactional
    @Override
    public UserEntity get(int id) {
    	return this.userDao.get(id);
    }

    @Transactional
	@Override
	public UserEntity getByProperty(String property, String condition) {
		
		return this.userDao.getByProperty(property, condition);
	}

}
