package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
