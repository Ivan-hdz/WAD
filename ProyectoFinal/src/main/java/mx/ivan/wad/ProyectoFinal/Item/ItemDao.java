package mx.ivan.wad.ProyectoFinal.Item;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.Dao;

public class ItemDao implements Dao<ItemEntity> {


    private SessionFactory sessionFactory;
		
	@Override
	public void create(ItemEntity object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ItemEntity itemEntity = this.getSessionFactory().getCurrentSession().get(ItemEntity.class, id);
        if(itemEntity != null)
            this.getSessionFactory().getCurrentSession().delete(itemEntity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemEntity> getAll() {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().createQuery("from ItemEntity ").list();
	}

	@Override
	public ItemEntity get(int id) {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().find(ItemEntity.class, id);
	}

	@Override
	public ItemEntity getByProperty(String property, String condition) {
		Query<ItemEntity> q = this.getSessionFactory().getCurrentSession().createQuery("from UserEntity where " + property + " = :condition", ItemEntity.class);
//		q.setParameter("property", property);
		q.setParameter("condition", condition);
		return (ItemEntity) q.uniqueResult();
	}

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
