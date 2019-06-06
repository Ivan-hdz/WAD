package mx.ivan.wad.ProyectoFinal.Item;

import javax.persistence.*;

@Entity
@Table(name = "c_item")
public class ItemEntity {
	
	@Id
	@Column(updatable = false, insertable = false)
	@GeneratedValue
	private int id;
	
	@Column(length = 200, nullable = false, updatable = false, insertable = false)
	private String name;
	@Column(length = 2500, nullable = false, updatable = false, insertable = false)
	private String description;
	@Column(length = 6, nullable = false, updatable = false, insertable = false)
	private Float price;
	@Column(name= "img_url", length = 1500, updatable = false, insertable = false)
	private String imgUrl;
	
	public void setImgUrl(String url) {
		this.imgUrl = url;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Integer getId() { return this.id; }
	
	public String getName() {return this.name; }
	
	public String getDescription() { return this.description; }
	
	public Float getPrice() { return this.price; }
	
	public String getImgUrl() { return this.imgUrl; }

}
