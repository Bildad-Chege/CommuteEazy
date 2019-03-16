package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Entities.PlaceOnRoute;
import com.bilchege.commuteazy.Entities.Terminus;
import com.bilchege.commuteazy.ResponseObj;
import com.bilchege.commuteazy.Services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping(method = RequestMethod.POST,value = "/addOperator")
    public void addOperator(@RequestBody Operator operator){
        operatorService.addOperator(operator);
    }

    @RequestMapping("/operators")
    public HashSet<Operator> getOperators(){
        return operatorService.getOperators();
    }

    @RequestMapping(path="/operatorsonroute/{origin}/{destination}")
    public List<ResponseObj> opertorsOnRoute(@PathVariable("origin")String origin,@PathVariable("destination")String destination){
        return operatorService.operatorsOnRoute(origin,destination);
    }

    @RequestMapping("/getoperator/{id}")
    public Optional<Operator> getOperator(@PathVariable("id") Long id){
        return operatorService.getOperator(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateoperator/{id}")
    public void updateOperator(@PathVariable Long id,@RequestBody Operator operator){
        operatorService.updateOperator(id,operator);
    }

}
