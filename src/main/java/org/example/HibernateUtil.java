package org.example;

import lombok.Getter;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    @Getter
    private static SessionFactory sessionFactory;
    private static final HibernateUtil INSTANCE;

    static {
        try {
            INSTANCE = new HibernateUtil();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private HibernateUtil() {
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:testdb", "sa", null).load();
        flyway.migrate();

        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Planet.class);
        configuration.addAnnotatedClass(Ticket.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
