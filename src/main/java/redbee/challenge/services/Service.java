package redbee.challenge.services;
import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */
public abstract class Service <T>{

    public abstract T findById(String id) throws Exception;
    public abstract List<T> findByName(String name) throws Exception;
    public abstract List<T> findAll();
    public abstract T save (T obj) ;
    public abstract void save(List<T> list);
    public abstract T update (T obj);
    public abstract void delete(String id);


}
