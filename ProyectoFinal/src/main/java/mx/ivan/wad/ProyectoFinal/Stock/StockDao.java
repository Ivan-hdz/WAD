package mx.ivan.wad.ProyectoFinal.Stock;

import java.util.List;

import org.hibernate.SessionFactory;

import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;

public class StockDao implements Dao<StockEntity> {
	
	private SessionFactory sessionFactory;

	@Override
	public void create(StockEntity object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StockEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockEntity get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockEntity getByProperty(String property, String condition) {
		// TODO Auto-generated method stub
		return null;
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
