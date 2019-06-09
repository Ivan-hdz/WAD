package mx.ivan.wad.ProyectoFinal.Stock;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.ActionController;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import mx.ivan.wad.ProyectoFinal.Utils.EmailSender;


public class StockAction extends ActionSupport implements ActionController<StockEntity>, Preparable, SessionAware {

	private Service<StockEntity> stockService;
	
	@Getter
	@Setter
	private String stripeToken;
	
	private String message;
	
	private int totalInCents;
	
	private Map<String, Object> session;
	
	public String doCheckout() {
		Charge charge ;
		Stripe.apiKey = getText("stripe.private");
		StringBuffer sbDesc = new StringBuffer();
		
		UserEntity cu = (UserEntity)session.get(getText("session.currentUser"));
		sbDesc.append("Compra de ");
		sbDesc.append(cu.getEmail());
		sbDesc.append(" por ");
		sbDesc.append(String.valueOf(totalInCents / 100));
		sbDesc.append(" MXN.");
		prepareRecipe();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("amount", totalInCents);
		params.put("currency", "mxn");
		params.put("source", stripeToken);
		params.put("description", sbDesc.toString());
		params.put("receipt_email", cu.getEmail());
		try {
			charge = Charge.create(params);
			if(charge.getPaid()) {
				EmailSender email = new EmailSender();
				email.setFrom(getText("email.user"));
				email.setFromPassword(getText("email.password"));
				email.setTo(cu.getEmail());
				email.setSubject(getText("title.email.purchase"));
				email.setMensaje(message);
				email.send();
				session.put(getText("session.cart"), new ArrayList<StockEntity>());
			}else {
				addActionError(getText("message.error.genericFailure"));
				return INPUT;
			}
		} catch (StripeException e) {
			// TODO Auto-generated catch block
			addActionError(e.getStripeError().getMessage());
			
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		addActionMessage(getText("message.info.purchaseSuccess"));
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		totalInCents = 0;
		message = "";
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

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	private void prepareRecipe() {
		StringBuffer sb = new StringBuffer(getText("message.email.firstHalf"));
		float total = 0.0f;
		List<StockEntity> cart = (List<StockEntity>) session.get(getText("session.cart"));
		for(StockEntity prod : cart) {
			sb.append("<tr><td>");
			sb.append(prod.getItem().getName());
			sb.append("</td><td>");
			sb.append(String.valueOf(prod.getQuantity()));
			sb.append("</td><td>");
			sb.append(String.valueOf(prod.getItem().getPrice()));
			sb.append("</td><td></tr>");
			total += prod.getItem().getPrice() * Float.parseFloat(String.valueOf(prod.getQuantity()));
		}
		sb.append("<tr><td><b>Total:</b></td>");
		sb.append("<td></td><td>");
		sb.append(String.valueOf(total));
		sb.append("</td></tr>");
		sb.append(getText("message.email.secondHalf"));
		message = sb.toString();
		totalInCents = (int)(total * 100);
	}

}
