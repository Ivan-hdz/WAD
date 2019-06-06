package mx.ivan.wad.ProyectoFinal.Stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mx.ivan.wad.ProyectoFinal.Item.ItemEntity;

@Entity
@Table(name="e_stock")
public class StockEntity {
	@Id
	@GeneratedValue
	@Column(updatable = false, insertable = false)
	private int id;
	
	@OneToOne
	private ItemEntity item;
	
	@Column(nullable = false)
	private int quantity;
	
	public int getId() {return id;}
	
	public ItemEntity getItem() {return item;}
	
	public int getQuantity() {return quantity;}
	
	public void setId(int id) { this.id = id; }
	
	public void setItem(ItemEntity item) { this.item = item; }
	
	public void setQuantity(int q) { this.quantity = q; }
	
}
