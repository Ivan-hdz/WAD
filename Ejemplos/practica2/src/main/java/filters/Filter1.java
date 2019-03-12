package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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
        String fecha, ip, metodo, recurso, hora;
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat df2 = new SimpleDateFormat("hh:mm:ss");
        fecha = df.format(new Date());
        hora = df2.format(new Date());
        Logger log = Logger.getAnonymousLogger();
        log.setLevel(Level.INFO);
        sb.append(request.getRemoteAddr()).append(" | ").append(fecha).append(" | ").append(hora).append(" | ").append(((HttpServletRequest)request).getMethod()).append(" | ").append(((HttpServletRequest) request).getRequestURI());
        log.info(sb.toString());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Destruyendo filtro 1");
    }
}
