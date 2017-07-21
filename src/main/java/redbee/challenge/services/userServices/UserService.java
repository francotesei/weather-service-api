package redbee.challenge.services.userServices;

import org.springframework.beans.factory.annotation.Autowired;
import redbee.challenge.Properties;
import redbee.challenge.services.ServiceFactory;
import redbee.challenge.models.User;


import java.util.List;

/**
 * Created by ftesei on 10/07/17.
 */

public class UserService extends UserBaseService {
    @Autowired
    private UserBaseService service = ServiceFactory.createServiceUser();


    public UserService(){


    };
    @Override
    public User findById(String id) throws Exception {
        return service.findById(id);
    }

    @Override
    public List<User> findByName(String name) throws Exception {
        return service.findByName(name);
    }

    @Override
    public List<User> findAll()  {
      return  service.findAll();

    }

    @Override
    public User save(User obj) {
    return service.save(obj);
    }

    @Override
    public void save(List<User> list) {
        service.save(list);
    }

    @Override
    public User update(User obj) {
        return service.update(obj);
    }
    @Override
    public void delete(String id) {
    service.delete(id);
    }


}
