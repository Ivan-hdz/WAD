                                           package mx.ivan.wad.ProyectoFinal.User;


import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "e_user")
public class UserEntity {

    
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private int id;

    
    @Column(updatable = false)
    private String email;

    
    @Column(updatable = false)
    private String password;

    
    @Column(updatable = false)
    private String name;

    @Validations(
			requiredStrings = {@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "user.password",key = "message.error.fieldRequired" )}
	)
    public String getPassword() {
        return password;
    }
    
    @Validations(
			requiredStrings = {@RequiredStringValidator( type = ValidatorType.FIELD, fieldName = "user.name",key = "message.error.fieldRequired" )}
    )
    public String getName() {
        return name;
    }

    @Validations(
			emails = { 
						@EmailValidator(type = ValidatorType.FIELD,  fieldName = "user.email", key = "message.error.invalidEmail")
					},
			requiredStrings = {
						@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "user.email", key = "message.error.fieldRequired")
					}
	)
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
   
    public void setName(String name) {
    	this.name = name;
    }

    public void setEmail(String email) {
    	this.email = email;
    }

    public void setPassword(String password) {
    	this.password = password;
    }
    
    
    
}
