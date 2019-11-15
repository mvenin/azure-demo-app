package ro.mve.dao;

import ro.mve.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);
	Optional<User> findById(long id);

	void deleteById(long id);
}
