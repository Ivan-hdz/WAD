package filters;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterA implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("The filter A is coming");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        System.out.println("--------------------");
        System.out.println("Filtering on A");
        if(request.getParameter("id").contains("f")) {
            System.out.println("Forwarding");
            RequestDispatcher rd = request.getRequestDispatcher("Lobby");
            System.out.println("--------------------");
            rd.forward(request, response);
        } else {
            System.out.println("Not forwarding");
            System.out.println("--------------------");
            chain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {
        System.out.println("The filter A is ending");
    }
}
