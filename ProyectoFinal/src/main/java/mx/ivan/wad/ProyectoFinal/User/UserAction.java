package mx.ivan.wad.ProyectoFinal.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

import java.util.List;

public class UserAction extends ActionSupport implements Preparable, ModelDriven<UserEntity> {
    @Setter
    @Getter
    private List<UserEntity> users;
    
    @Getter
    private Integer idSel;

    @Setter
    @Getter
    private String message;
    
    @Setter
    @Getter
    private UserEntity user;

    @Setter
    @Getter
    private Service<UserEntity> userService;
    
    

    @Override
    public void prepare() throws Exception {
        user = null;
    }
    
    @VisitorFieldValidator
    public String create() {
        userService.create(user);
        return SUCCESS;
    }
    
    
    public String list() {
        users = userService.getAll();
        return SUCCESS;
    }
    
    public String delete() {
        userService.delete(user.getId());
        return SUCCESS;
    }
    
    @VisitorFieldValidator
    public void setIdSe(int id) {
    	this.idSel = id;
    	if(idSel != null) {
    		user = userService.get(id);
    	}
    }
    @Override
    @VisitorFieldValidator
    public UserEntity getModel() {
        return user;
    }
   
    @VisitorFieldValidator
	public Integer getIdSel() {
		return idSel;
	}
    
    
}
