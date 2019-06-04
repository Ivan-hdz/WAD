package mx.ivan.wad.ProyectoFinal.User;


import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "e_user")
public class UserEntity {

    @Setter
    @Id
    @GeneratedValue
    @Column(updatable = false)
    private int id;

    @Setter
    @Column(updatable = false)
    private String email;

    @Setter
    @Column(updatable = false)
    private String password;

    @Setter
    @Column(updatable = false)
    private String name;

    public String getPassword() {
        return password;
    }

	@Validations(
			emails = { @EmailValidator(type = ValidatorType.SIMPLE, fieldName = "user.email", key = "message.error.invalidEmail") },
			requiredStrings = {@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "user.email", key = "message.error.fieldRequired")}
	)
    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
