package config;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebServletConfiguration implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webctx=new AnnotationConfigWebApplicationContext();
        webctx.register(ClientWebConfig.class);
        webctx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(webctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        /*
        On ajoute un servlet pour accéder à la console du SGBD H2
        L'url est celle de votre projet + "/console"
        Dans la fenêtre de connexion il faut changer la valeur de JDBC URL : jdbc:h2:mem:testdb
         */

        ServletRegistration.Dynamic h2servlet = servletContext
                .addServlet("h2-console", new JakartaWebServlet());
        h2servlet.setLoadOnStartup(2);
        h2servlet.addMapping("/console/*");
    }
}
