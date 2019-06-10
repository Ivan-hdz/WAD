package mx.ivan.wad.ProyectoFinal.Ticket;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.ActionController;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

public class TicketAction extends ActionSupport implements Preparable, ActionController<TicketEntity>, SessionAware {

	private Service<TicketEntity> ticketService;
	
	@Getter
	@Setter
	private List<TicketEntity> tickets;
	
	private Map<String, Object> session;
	
	public String getMyTickets() {
		UserEntity cu = (UserEntity)session.get(getText("session.currentUser"));
		tickets = (List<TicketEntity>) ticketService.getAllByProperty("user_id", cu.getId(), TicketEntity.class);
		return SUCCESS;
	}
	

	
	@Override
	public Service<TicketEntity> getService() {
		// TODO Auto-generated method stub
		return this.ticketService;
	}

	@Override
	public void setService(Service<TicketEntity> service) {
		// TODO Auto-generated method stub
		this.ticketService = service;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		this.tickets = null;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
