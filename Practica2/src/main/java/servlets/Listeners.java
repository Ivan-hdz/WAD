package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listeners implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("<----------------->");
        System.out.println("attributeAdded");
        System.out.println(event.getName());
        System.out.println(event.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("<----------------->");
        System.out.println("attributeRemoved");
        System.out.println(event.getName());
        System.out.println(event.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("<----------------->");
        System.out.println("attributeReplaced");
        System.out.println(event.getName());
        System.out.println(event.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("<----------------->");
        System.out.println("contextInitialized");
        System.out.println(sce.getServletContext().getContextPath());
        System.out.println("<----------------->");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("<----------------->");
        System.out.println("contextDestroyed");
        System.out.println(sce.getServletContext().getContextPath());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("<----------------->");
        System.out.println("attributeAdded");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("<----------------->");
        System.out.println("attributeRemoved");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("<----------------->");
        System.out.println("attributeReplaced");
        System.out.println(srae.getName());
        System.out.println(srae.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("<----------------->");
        System.out.println("requestDestroyed");
        System.out.println(sre.getServletRequest().getServerName());
        System.out.println("<----------------->");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("<----------------->");
        System.out.println("requestInitialized");
        System.out.println(sre.getServletRequest().getServerName());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("<----------------->");
        System.out.println("attributeAdded");
        System.out.println(event.getName());
        System.out.println(event.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("<----------------->");
        System.out.println("attributeRemoved");
        System.out.println(event.getName());
        System.out.println(event.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("<----------------->");
        System.out.println("attributeReplaced");
        System.out.println(event.getName());
        System.out.println(event.getValue());
        System.out.println("<----------------->");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("<----------------->");
        System.out.println("sessionCreated");
        System.out.println(se.getSession().getCreationTime());
        System.out.println("<----------------->");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("<----------------->");
        System.out.println("sessionDestroyed");
        System.out.println(se.getSession().getCreationTime());
        System.out.println("<----------------->");
    }
}
