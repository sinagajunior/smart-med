package smartmed.general.repository;

import org.springframework.data.repository.CrudRepository;
import smartmed.general.model.User;

public interface UserDao extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
