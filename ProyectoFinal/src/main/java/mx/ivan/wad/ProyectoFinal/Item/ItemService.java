package mx.ivan.wad.ProyectoFinal.Item;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;

public class ItemService implements Service<ItemEntity>{

	@Getter
	@Setter
	private Dao<ItemEntity> itemDao;
	
	@Override
	@Transactional
	public void create(ItemEntity object) {
		itemDao.create(object);
	}

	@Override
	@Transactional
	public void delete(int id) {
		itemDao.delete(id);
	}

	@Override
	@Transactional
	public ItemEntity get(int id) {
		return itemDao.get(id);
	}

	@Override
	@Transactional
	public List<ItemEntity> getAll() {
		return itemDao.getAll();
	}

	@Override
	@Transactional
	public ItemEntity getByProperty(String property, String condition) {
		return itemDao.getByProperty(property, condition);
	}

}
