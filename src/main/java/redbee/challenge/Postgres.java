package redbee.challenge;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by ftesei on 20/07/17.
 */
public class Postgres {
    final Configuration configuration = new Configuration().configure();
    final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    private SessionFactory factory;
    Postgres(){
    factory =configuration.buildSessionFactory(builder.build());
}
private static class PostgresSing{
    private static final Postgres INSTANCE = new Postgres();
}
public static  Postgres getInstance(){
        System.out.println("Start Postgres DB");
        return PostgresSing.INSTANCE;}
public Session getFactory(){
    return factory.openSession();
}
}
