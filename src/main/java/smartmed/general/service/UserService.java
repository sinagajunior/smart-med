package smartmed.general.service;

import smartmed.general.model.User;

import java.util.List;

/**
 * @project general
 * @Author royantonius on 22/01/19 .
 */
public interface UserService {
    User save (User user);
    List<User> findAll();
    void Delete(long id);

}
