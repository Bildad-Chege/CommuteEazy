package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    public Optional<User> findUserByUserNameAndAccountPassword(String userName, String password);
}
