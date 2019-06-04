package mx.ivan.wad.ProyectoFinal.Interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

import org.apache.struts2.StrutsStatics;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class CharsetInterceptor implements Interceptor {
 

    private static Logger logger = Logger.getLogger(CharsetInterceptor.class.getName());

    @Override
    public void destroy() { }

    @Override
    public void init() { }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        logger.info("Setting UTF-8");
        ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
        HttpServletResponse response=(HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        return invocation.invoke();
    }
}
