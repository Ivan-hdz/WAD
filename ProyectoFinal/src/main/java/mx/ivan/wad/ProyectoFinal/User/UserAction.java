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

public class UserAction extends ActionSupport implements Preparable {

 
    private Integer idSel;
    
    private UserEntity user;

    private Service<UserEntity> userService;
    
    public void setUser(UserEntity u) {
    	user = u;
    }
    
    @VisitorFieldValidator
    public UserEntity getUser() {
    	return user;
    }
    
    public void setUserService(Service<UserEntity> us) {
    	userService = us;
    }
    public Service<UserEntity> getUserService() {
    	return userService;
    }
    
    public void setIdSe(int id) {
    	this.idSel = id;
    	if(idSel != null) {
    		user = userService.get(id);
    	}
    }
	public Integer getIdSel() {
		return idSel;
	}
    

    
    
    @Override
    public void prepare() throws Exception {
        user = null;
    }
    

    public String signup() {
        userService.create(user);
        addActionMessage(getText("message.info.accountCreated"));
        return SUCCESS;
    }
    
    public String login() {
    	
    	return SUCCESS;
    }
    
    
    public String delete() {
        userService.delete(user.getId());
        return SUCCESS;
    }
    
    
    
    



    
    
}
