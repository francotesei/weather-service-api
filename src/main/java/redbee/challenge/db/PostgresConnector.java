package redbee.challenge.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import redbee.challenge.Postgres;
import redbee.challenge.services.Service;

import java.util.List;

/**
 * Created by ftesei on 11/07/17.
 */
public class PostgresConnector implements DBConnector {
   // private SessionFactory factory;
    private Session session;

    public PostgresConnector(){
    }
    @Override
    public void connect() {
        session = Postgres.getInstance().getFactory();

    }

    @Override
    public void disconnect() {
        session.close();
    }
    public Session getOperations(){
        return session;
    }

    public void commit(){
        session.getTransaction().commit();
    }
    public void beginTransaction(){
        session.beginTransaction();
    }
}
