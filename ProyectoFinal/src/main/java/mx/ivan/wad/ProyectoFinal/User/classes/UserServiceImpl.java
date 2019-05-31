package mx.ivan.wad.ProyectoFinal.User.classes;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import mx.ivan.wad.ProyectoFinal.User.interfaces.UserDao;
import mx.ivan.wad.ProyectoFinal.User.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Setter
    @Getter
    private UserDao userDao;

    @Transactional
    @Override
    public void createUser(UserEntity user) {
        this.userDao.createUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int userId) {
        this.userDao.deleteUser(userId);
    }

    @Transactional
    @Override
    public List<UserEntity> listUsers() {
        return this.userDao.listUsers();
    }

}
