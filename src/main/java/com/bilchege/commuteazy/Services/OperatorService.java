package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.Operator;
import com.bilchege.commuteazy.Repositories.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private PlaceService placeService;

    public List<Operator> getOperators(){
        List<Operator> thisList = new ArrayList<>();
        operatorRepository.findAll().forEach(thisList::add);
        return thisList;
    }

    public Optional<Operator> getOperator(Long id){
        Operator o = new Operator();
        operatorRepository.findById(id).ifPresent(operator ->{
            o.setOperatorID(operator.getOperatorID());
            o.setOperatorName(operator.getOperatorName());
            o.setEmail(operator.getEmail());
            o.setPhone(operator.getPhone());
            o.setAccountPassword(operator.getAccountPassword());
            o.setPlacesSet(operator.getPlacesSet());
            o.setTermini(operator.getTermini());
                }
                );
        return Optional.ofNullable(o);
    }

    public void addOperator(Operator operator){
        operatorRepository.save(operator);
    }

    public void updateOperator(Long id,Operator operator){
        operatorRepository.save(operator);
    }

    public List<Operator> operatorsOnRoute(String origin,String destination){
        return operatorRepository.fetchOperatorOnRoute(origin,destination);
    }

}
