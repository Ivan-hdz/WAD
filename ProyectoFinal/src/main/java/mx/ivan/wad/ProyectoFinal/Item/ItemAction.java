package mx.ivan.wad.ProyectoFinal.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;

public class ItemAction extends ActionSupport implements Preparable, SessionAware {

	private Service<ItemEntity> itemService;
	
	private Map<String, Object> session;
	
	private List<ItemEntity> items;
	
	private ItemEntity item;
	
	private UserEntity user;
	
	public Service<ItemEntity> getItemService() { return itemService; }
	
	public void setItemService(Service<ItemEntity> service) { this.itemService = service; }
	
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
	public void setUser(UserEntity u) {
    	user = u;
    }
    
    @VisitorFieldValidator
    public UserEntity getUser() {
    	return user;
    }
	
	public String addToCart() {
		if(item != null) {
			try {
				item = itemService.get(item.getId());
				List<ItemEntity> cart = (List<ItemEntity>) session.get(getText("session.cart")); //Null Pointer Exception
				if(cart == null) {
					cart = new ArrayList<ItemEntity>();
				}
				cart.add(item);
				session.put(getText("session.cart"), cart);
				System.out.println(hasActionErrors());
				addActionMessage(getText("message.info.addedSuccess"));
				return SUCCESS;
			} catch(Exception e) {
				e.printStackTrace();
				addActionError(getText("message.error.addedFailure"));
			}
		}
		return INPUT;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
