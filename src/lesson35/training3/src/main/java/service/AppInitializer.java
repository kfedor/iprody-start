package service;

import com.sun.xml.ws.transport.http.servlet.WSServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    private final WSServletContextListener servletContainerInitializer = new WSServletContextListener();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        servletContainerInitializer.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContainerInitializer.contextDestroyed(sce);
    }
}
