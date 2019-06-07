package mx.ivan.wad.ProyectoFinal.Stock;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;

public class StockDao implements Dao<StockEntity> {
	
   private SessionFactory sessionFactory;
	
	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}
		
}
