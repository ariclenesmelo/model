
package br.com.ariclenesmelo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
    
    private static final SessionFactory session_factory;
    public static final String HIBERNATE_SESSION = "session_factory";
    
    static {
    
        try {
            System.out.println("Tentando configurar uma SF");
            
            Configuration configuration = new Configuration().configure();
            
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            
            session_factory = configuration.buildSessionFactory(serviceRegistry);
            
            System.out.println("SF criada com Sucesso");
            
        } catch (Exception ex) {
            
            System.out.println("Ocorreu um erro ao iniciar a SF");
            
            throw new ExceptionInInitializerError(ex);
        }
    
    }

    public static SessionFactory getSession_factory() {
        return session_factory;
    }
    
}
