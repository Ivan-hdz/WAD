package mx.ivan.wad.ProyectoFinal.Stock;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import mx.ivan.wad.ProyectoFinal.Interfaces.ActionController;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;


public class StockAction extends ActionSupport implements ActionController<StockEntity>, Preparable {

	private Service<StockEntity> stockService;
	
	public String doCheckout() {
		
		addActionMessage("doCheckOut");
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Service<StockEntity> getService() {
		// TODO Auto-generated method stub
		return this.stockService;
	}

	@Override
	public void setService(Service<StockEntity> service) {
		// TODO Auto-generated method stub
		this.stockService = service;
	}

}
