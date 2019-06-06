package mx.ivan.wad.ProyectoFinal.Stock;

import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;

public class StockService implements Service<StockEntity> {

	private Dao<StockEntity> stockDao;
	
	@Override
	public Dao<StockEntity> getDao() {
		// TODO Auto-generated method stub
		return stockDao;
	}

	@Override
	public void setDao(Dao<StockEntity> dao) {
		// TODO Auto-generated method stub
		this.stockDao = dao;
	}

}
