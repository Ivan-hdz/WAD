package mx.ivan.wad.ProyectoFinal.Stock;


import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.ActionController;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;


public class StockAction extends ActionSupport implements ActionController<StockEntity>, Preparable {

	private Service<StockEntity> stockService;
	
	@Getter
	@Setter
	private String stripeToken;
	
	
	public String doCheckout() {
		Charge charge ;
		Stripe.apiKey = getText("stripe.private");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("amount", 100);
		params.put("currency", "usd");
		params.put("source", stripeToken);
		params.put("description", "Testing Stripe");
		params.put("receipt_email", "honter1997@gmail.com");
		try {
			charge = Charge.create(params);
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			addActionError(e.getMessage());
			return INPUT;
		}
		addActionMessage(charge.getPaid().toString());
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
