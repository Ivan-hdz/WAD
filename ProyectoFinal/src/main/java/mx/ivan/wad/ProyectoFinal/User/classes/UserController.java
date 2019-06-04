package mx.ivan.wad.ProyectoFinal.User.classes;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import mx.ivan.wad.ProyectoFinal.User.interfaces.UserService;

import java.util.List;


public class UserController extends ActionSupport implements Preparable, ModelDriven<UserEntity> {
    @Setter
    @Getter
    private List<UserEntity> users;

    @Setter
    @Getter
    private String message;
    
    @Setter
    @Getter
    private UserEntity user;

    @Setter
    @Getter
    private UserService userService;

    @Override
    public void prepare() throws Exception {
        user = null;
    }
    public String create() {
    	
        userService.createUser(user);
        return SUCCESS;
    }
    public String list() {
        users = userService.listUsers();
        return SUCCESS;
    }
    public String delete() {
        userService.deleteUser(user.getId());
        return SUCCESS;
    }

    @Override
    @VisitorFieldValidator(appendPrefix = true)
    public UserEntity getModel() {
        return user;
    }
}
