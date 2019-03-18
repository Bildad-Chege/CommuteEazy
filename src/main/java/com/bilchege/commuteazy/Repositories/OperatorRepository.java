package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.ResponseObj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperatorRepository extends CrudRepository<Operator,Long> {
    @Query("select new com.bilchege.commuteazy.ResponseObj(o.operatorName,p.address,p.latitude,p.longitude) from Operator o inner join o.places p where p.placeID = ?1 or p.placeID = ?2 and p.placeID = ?1")
    List<ResponseObj> fetchOperatorOnRoute(String origin,String destination);

}
