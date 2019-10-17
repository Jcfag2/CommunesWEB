package fr.gtm.communes.servlets;

import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import fr.gtm.communes.Constantes;
import fr.gtm.communes.services.CommuneServices;



@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger("communes");

    public void contextDestroyed(ServletContextEvent sce)  { 
    	EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
    	emf.close();
    	LOG.info(">>> EMF fermé");
    	LOG.info(">>> Application detruite");
    }


    public void contextInitialized(ServletContextEvent sce)  { 
        LOG.info(">>> Application démarée");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("communes");
        LOG.info(">>> EMF: "+emf);
        ServletContext application = sce.getServletContext();
        application.setAttribute(Constantes.EMF, emf);
        CommuneServices service = new CommuneServices(emf);
        LOG.info(">>> Service: "+service);
        application.setAttribute(Constantes.COMMUNE_SERVICE, service);
    }
    
   
	
}
