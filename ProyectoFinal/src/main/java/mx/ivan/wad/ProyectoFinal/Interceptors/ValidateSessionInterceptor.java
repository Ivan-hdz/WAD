package mx.ivan.wad.ProyectoFinal.Interceptors;

import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.ValidationAware;

public class ValidateSessionInterceptor implements Interceptor, ServletContextAware {
	
	private String SESSION_VALID_KEY = "isValid";
	private static Logger logger = Logger.getLogger(ValidateSessionInterceptor.class.getName());
	private ServletContext context;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		logger.info("Validating session");
		Boolean loggedIn = false;
        HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		try {
			ActionSupport as = (ActionSupport)invocation.getAction();
			loggedIn = (boolean)session.get(as.getText("session.loggedIn"));
			
		} catch(Exception e) {
			logger.warning(e.getMessage());
			loggedIn = false;
		}
		if(loggedIn)
		{
			return invocation.invoke();
		} else {
			response.sendRedirect(context.getContextPath() + "/home");
			return Action.INPUT;
		}
		
		
	}

	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}
	
}
