package mx.ivan.wad.ProyectoFinal.Ticket;

import org.hibernate.SessionFactory;

import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Item.ItemEntity;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

public class TicketDao implements Dao<TicketEntity> {
	
	private SessionFactory sessionFactory;
	
	@Override
	public void create(TicketEntity object) {
		// TODO Auto-generated method stub
		UserEntity cu = sessionFactory.getCurrentSession().load(UserEntity.class, object.getUser().getId());
		ItemEntity item = sessionFactory.getCurrentSession().load(ItemEntity.class, object.getItem().getId());
		object.setUser(cu);
		object.setItem(item);
		sessionFactory.getCurrentSession().save(object);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public SessionFactory getSessionFactory() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return this.sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}

}
