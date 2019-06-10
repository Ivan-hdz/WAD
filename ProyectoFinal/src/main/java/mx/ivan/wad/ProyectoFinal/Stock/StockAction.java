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
import com.stripe.model.Refund;

import lombok.Getter;
import lombok.Setter;
import mx.ivan.wad.ProyectoFinal.Interfaces.ActionController;
import mx.ivan.wad.ProyectoFinal.Interfaces.Service;
import mx.ivan.wad.ProyectoFinal.Ticket.TicketEntity;
import mx.ivan.wad.ProyectoFinal.User.UserEntity;
import mx.ivan.wad.ProyectoFinal.Utils.EmailSender;

// Si da tiempo, separo lo de emails en un interceptor
public class StockAction extends ActionSupport implements  ActionController<StockEntity>, Preparable, SessionAware {

	private Service<StockEntity> stockService;
	@Setter
	@Getter
	private Service<TicketEntity> ticketService;
	
	@Getter
	@Setter
	private String stripeToken;
	
	private String emailMessage;
	
	private String emailTo;
	
	private int totalInCents;
	
	private Map<String, Object> session;
	
	public String doCheckout() {
		Charge charge ;
		Stripe.apiKey = getText("stripe.private");
		prepareRecipe();
		
		try {
			charge = Charge.create(getChargeParams());
			if(charge.getPaid()) {
				if(updateStock()) {
					generateTicket();
					sendEmail();
				} else {
					Map<String, Object> refundParams = new HashMap<String, Object>();
					refundParams.put("charge", charge.getId());
					Refund.create(refundParams);
					addActionError(getText("message.error.outOfStock"));
					return INPUT;
				}
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
		emailMessage = "";
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
	
	private void generateTicket() {
		UserEntity cu = (UserEntity)session.get(getText("session.currentUser"));
		StringBuffer buffId = new StringBuffer("U");
		buffId.append(cu.getId());
		buffId.append("-");
		buffId.append((int)(Math.random()*1000));
		buffId.append(totalInCents);
		String orderId = buffId.toString();
		List<StockEntity> cart = (List<StockEntity>) session.get(getText("session.cart"));
		for(StockEntity s: cart) {
			TicketEntity ticketEntry = new TicketEntity();
			ticketEntry.setItem(s.getItem());
			ticketEntry.setOrderId(orderId);
			ticketEntry.setQuantity(s.getQuantity());
			ticketEntry.setSubtotal(s.getItem().getPrice() * s.getQuantity());
			ticketEntry.setUser(cu);
			ticketService.create(ticketEntry);
		}
	}
	
	private void sendEmail() {
		EmailSender email = new EmailSender();
		email.setFrom(getText("email.user"));
		email.setFromPassword(getText("email.password"));
		email.setTo(emailTo);
		email.setSubject(getText("title.email.purchase"));
		email.setMensaje(emailMessage);
		email.send();
	}
	
	private boolean updateStock() {
		
		return true;
	}
	
	private Map<String, Object> getChargeParams() {
		UserEntity cu = (UserEntity)session.get(getText("session.currentUser"));
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer description = new StringBuffer();
		emailTo = cu.getEmail();
		description.append("Compra de ");
		description.append(emailTo);
		description.append(" por ");
		description.append(String.valueOf(totalInCents / 100));
		description.append(" MXN.");
		params.put("amount", totalInCents);
		params.put("currency", "mxn");
		params.put("source", stripeToken);
		params.put("description", description.toString());
		params.put("receipt_email", emailTo);
		return params;
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
		emailMessage = sb.toString();
		totalInCents = (int)(total * 100);
	}

}
