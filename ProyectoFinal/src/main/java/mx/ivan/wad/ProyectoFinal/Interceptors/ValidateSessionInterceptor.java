package mx.ivan.wad.ProyectoFinal.Interceptors;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.ValidationAware;

public class ValidateSessionInterceptor implements Interceptor {
	
	private String SESSION_VALID_KEY = "isValid";
	private static Logger logger = Logger.getLogger(ValidateSessionInterceptor.class.getName());

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
		HttpSession session = (HttpSession) invocation.getInvocationContext().getSession();
		if(session.getAttribute(SESSION_VALID_KEY) != null)
			return invocation.invoke();
		else {
			addActionError(invocation, "${getText('message.error.invalidSession')}");
			return Action.ERROR;
		}
		
		
	}
	
	private void addActionError(ActionInvocation invocation, String message) {
        Object action = invocation.getAction();
        if (action instanceof ValidationAware) {
            ((ValidationAware) action).addActionError(message);
        }
    }

}
