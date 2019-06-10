package mx.ivan.wad.ProyectoFinal.Ticket;

import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;

public class TicketService implements Service<TicketEntity> {
	
	private Dao<TicketEntity> ticketDao;

	@Override
	public Dao<TicketEntity> getDao() {
		// TODO Auto-generated method stub
		return this.ticketDao;
	}

	@Override
	public void setDao(Dao<TicketEntity> dao) {
		// TODO Auto-generated method stub
		this.ticketDao = dao;
	}



}
