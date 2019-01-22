package smartmed.general.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import smartmed.general.model.User;
import smartmed.general.repository.UserDao;
import smartmed.general.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project general
 * @Author royantonius on 22/01/19 .
 */


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService,UserService {

    @Autowired
    UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userDao.findByUsername(userName);
        if(user ==null){
            throw new UsernameNotFoundException("Invalid user name or password");

        }
      return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),
              user.getPassword(),getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
    List<User> list = new ArrayList<>();
     userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void Delete(long id) {
      userDao.deleteById(id);
    }
}
