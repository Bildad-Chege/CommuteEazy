package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.Terminus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TerminusRepository extends CrudRepository<Terminus,String> {

}
