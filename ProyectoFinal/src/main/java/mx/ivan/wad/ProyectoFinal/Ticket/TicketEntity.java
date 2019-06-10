package mx.ivan.wad.ProyectoFinal.Ticket;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Item.ItemEntity;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

@Entity
@Table(name="e_ticket")
public class TicketEntity {
	
	@Id
	@GeneratedValue
	@Column(updatable = false)
	private int id;
	
	// Al incluir el usuario en esta tabla me ahorro relacion ticket-usuario pero
	// va ha haber redundancia de datos en esta tabla
	
	@Getter
	@Setter
	@Column
	private String orderId;
	
	@Getter
	@Setter
	@OneToOne
	private UserEntity user;  
	
	@Getter
	@Setter
	@OneToOne
	private ItemEntity item;
	
	@Getter
	@Setter
	@Column
	private int quantity;
	
	@Getter
	@Setter
	@GeneratedValue
	@Column
	private Date date;
	
	@Getter
	@Setter
	@Column
	private float subtotal;
	

}
