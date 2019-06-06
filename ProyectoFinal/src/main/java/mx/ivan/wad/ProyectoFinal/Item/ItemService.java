package mx.ivan.wad.ProyectoFinal.Item;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;

public class ItemService implements Service<ItemEntity>{


	private Dao<ItemEntity> itemDao;

	@Override
	public Dao<ItemEntity> getDao() {
		// TODO Auto-generated method stub
		return itemDao;
	}

	@Override
	public void setDao(Dao<ItemEntity> dao) {
		// TODO Auto-generated method stub
		itemDao = dao;
	}

}
