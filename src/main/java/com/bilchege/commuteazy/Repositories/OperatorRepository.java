package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.Operator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperatorRepository extends CrudRepository<Operator,Long> {
    @Query("select o from Operator o inner join o.placesSet p where p.placeID = :origin or p.placeID = :destination")
    List<Operator> fetchOperatorOnRoute(String origin,String destination);
}
