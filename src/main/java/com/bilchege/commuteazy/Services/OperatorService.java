package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Repositories.OperatorRepository;
import com.bilchege.commuteazy.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private PlaceService placeService;

    public HashSet<Operator> getOperators(){
        HashSet<Operator> thisList = new HashSet<>();
        operatorRepository.findAll().forEach(thisList::add);
        return thisList;
    }

    public Optional<Operator> getOperator(Long id){
        Operator o = new Operator();
        return operatorRepository.findById(id);
    }

    public Operator addOperator(Operator operator){
        return operatorRepository.save(operator);
    }

    public void updateOperator(Long id,Operator operator){
        operatorRepository.save(operator);
    }

    public List<ResponseObj> operatorsOnRoute(String origin,String destination){
        return operatorRepository.fetchOperatorOnRoute(origin,destination);
    }

}
