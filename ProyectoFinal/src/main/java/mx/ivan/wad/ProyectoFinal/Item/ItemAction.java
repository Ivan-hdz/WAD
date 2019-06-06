package mx.ivan.wad.ProyectoFinal.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.ActionController;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.Stock.StockEntity;

public class ItemAction extends ActionSupport implements ActionController<ItemEntity>, Preparable, SessionAware {

	private Service<ItemEntity> itemService;
	
	private Map<String, Object> session;
	
	private List<ItemEntity> items;
	
	@Getter
	@Setter
	private List<StockEntity> userCart;
	
	private ItemEntity item;
	
	@Override
	public void prepare() throws Exception {
		this.items = null;
		this.item = null;
	}
	
	public void setItem(ItemEntity i) {
		this.item = i;
	}
	
	@VisitorFieldValidator
	public ItemEntity getItem() { return this.item; }
	
	public String getAll() {
		this.items = itemService.getAll();
		return SUCCESS;
	}
	
	public List<ItemEntity> getItems() {
		return this.items;
	}
	
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
	
	public String addToCart() {
		if(item != null) {
			try
			{
				boolean exists = false;
				item = itemService.get(item.getId());
				List<StockEntity> cart = (List<StockEntity>) session.get(getText("session.cart")); //Null Pointer Exception
				if(cart == null) {
					cart = new ArrayList<StockEntity>();
				}
				for(StockEntity userStock : cart) {
					if(userStock.getItem().getId() == item.getId()) 
					{
						userStock.setQuantity(userStock.getQuantity() + 1);
						exists = true;
						break;
					}
				}
				if(!exists) {
					StockEntity s = new StockEntity();
					s.setItem(item);
					s.setQuantity(1);
					cart.add(s);
				}
				session.put(getText("session.cart"), cart);
				addActionMessage(getText("message.info.addedSuccess"));
				return SUCCESS;
			} catch(Exception e) {
				e.printStackTrace();
				addActionError(getText("message.error.addedFailure"));
			}
		}
		return INPUT;
	}
	
	public String showCart() {
		try {
			List<StockEntity> cart = (List<StockEntity>) session.get(getText("session.cart")); //Null Pointer Exception
			if(cart == null) {
				cart = new ArrayList<StockEntity>();
			}
			this.userCart = cart;
			return SUCCESS;
		} catch(Exception e) {
			e.printStackTrace();
			addActionError(getText("message.error.genericFailure"));
		}
		return INPUT;
	}

	public String removeFromCart() {
		if(item != null) {
			try
			{
				item = itemService.get(item.getId());
				List<StockEntity> cart = (List<StockEntity>) session.get(getText("session.cart")); //Null Pointer Exception
				if(cart == null) {
					cart = new ArrayList<StockEntity>();
				}
				for(int i = 0; i<cart.size(); i++) 
				{
					StockEntity userStock = cart.get(i);
					if(userStock.getItem().getId() == item.getId()) 
					{
						userStock.setQuantity(userStock.getQuantity() - 1);
						if(userStock.getQuantity() == 0) {
							cart.remove(i);
						}
						break;
					}
				}
				session.put(getText("session.cart"), cart);
				addActionMessage(getText("message.info.removedSuccess"));
				return SUCCESS;
			} catch(Exception e) {
				e.printStackTrace();
				addActionError(getText("message.error.genericFailure"));
			}
		}
		return INPUT;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public Service<ItemEntity> getService() {
		// TODO Auto-generated method stub
		return this.itemService;
	}

	@Override
	public void setService(Service<ItemEntity> service) {
		// TODO Auto-generated method stub
		this.itemService = service;
	}

}
