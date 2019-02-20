package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.PlaceOnRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<PlaceOnRoute,String> {

}
