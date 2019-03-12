package filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filer B is coming");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("--------------------");
        System.out.println("Filtering on B");
        System.out.println("Solo puedes llegar aqui, filtro B, mediante forwarding");
        System.out.println("--------------------");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("Destroying filer B");
    }
}
