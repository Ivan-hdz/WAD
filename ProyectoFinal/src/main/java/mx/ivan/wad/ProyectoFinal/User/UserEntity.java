package mx.ivan.wad.ProyectoFinal.User;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "e_user")
public class UserEntity {
    @Setter
    @Getter
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Setter
    @Getter
    @Column
    private String email;

    @Setter
    @Getter
    @Column
    private String password;

    @Setter
    @Getter
    @Column
    private String name;


}
