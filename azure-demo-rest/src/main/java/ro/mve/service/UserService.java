package ro.mve.service;

import ro.mve.model.User;
import ro.mve.model.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);

    User findOne(String username);

    User findById(long id);

    UserDto update(UserDto userDto);
}
