package mx.ivan.wad.ProyectoFinal.User.interfaces;

import mx.ivan.wad.ProyectoFinal.User.UserEntity;

import java.util.List;

public interface UserService  {
    void createUser(UserEntity user);
    void deleteUser(int userId);
    List<UserEntity> listUsers();
}

