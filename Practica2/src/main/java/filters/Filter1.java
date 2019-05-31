package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Iniciando filtro 1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String fecha, ip, metodo, recurso, hora, allowed = "ALLOWED";
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession s = req.getSession();
        boolean auth = false;

        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm:ss");
        fecha = df.format(new Date());
        hora = df2.format(new Date());
        Logger log = Logger.getAnonymousLogger();
        log.setLevel(Level.INFO);

        if(!(req.getRequestURI().contains("Welcome") || req.getRequestURI().contains("public") || req.getRequestURI().equals("/practica2/") || req.getRequestURI().contains(".jsp"))) {
            auth = s.getAttribute("isLogged") != null;
            if(!auth) {
                allowed = "NOT ALLOWED";
            }
        }
        sb.append(request.getRemoteAddr()).append(" | ").append(fecha).append(" | ").append(hora).append(" | ").append(((HttpServletRequest)request).getMethod()).append(" | ").append(((HttpServletRequest) request).getRequestURI()).append(" | ").append(allowed);
        log.info(sb.toString());
        if(allowed.equals("ALLOWED")) {
            chain.doFilter(request, response);
        } else {
            res.sendError(404);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destruyendo filtro 1");
    }
}
