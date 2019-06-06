package mx.ivan.wad.ProyectoFinal.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

import java.util.Map;
import java.util.logging.Logger;


import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class UserAction extends ActionSupport implements Preparable, SessionAware {

	private Logger logger = Logger.getLogger(UserAction.class.getName());
    
    private UserEntity user;

    private Service<UserEntity> userService;
    
    private Map<String, Object> session;
    
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
    
    
    @Override
    public void prepare() throws Exception {
        user = null;
    }
    

    public String signup() {
        userService.create(user);
        addActionMessage(getText("message.info.accountCreated"));
        return SUCCESS;
    }
    
    @SkipValidation
    public String login() {
    	UserEntity placeholder = userService.getByProperty("email", user.getEmail());
    	if(placeholder != null) {
    		if(placeholder.getPassword().equals(user.getPassword())) {
    			session.put(getText("session.loggedIn"), true);
    			session.put(getText("session.currentUser"), placeholder);
    			addActionMessage(getText("message.info.loginSuccess"));
    			return SUCCESS;
    		}
    	} 
    	addActionError(getText("message.error.loginError"));
		return INPUT;
    }
    
    public String logout() {
    	session.remove(getText("session.loggedIn"));
    	session.remove(getText("session.currentUser"));
    	return SUCCESS;
    }
    
    
    public String delete() {
        userService.delete(user.getId());
        return SUCCESS;
    }

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
    
    
    
    



    
    
}
