package com.bilchege.commuteazy.Repositories;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.ResponseObj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperatorRepository extends CrudRepository<Operator,Long> {
    @Query("select new com.bilchege.commuteazy.ResponseObj(o.operatorName,p.address,p.latitude,p.longitude) from Operator o inner join o.placesSet p")
    List<ResponseObj> fetchOperatorOnRoute();
}
