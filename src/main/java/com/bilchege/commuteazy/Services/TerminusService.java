package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.Terminus;
import com.bilchege.commuteazy.Repositories.TerminusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TerminusService {

    @Autowired
    private TerminusRepository terminusRepository;

    public void addTerminus(Terminus terminus){
        terminusRepository.save(terminus);
    }

    public Optional<Terminus> getTerminus(String id){
        return terminusRepository.findById(id);
    }

    public List<Terminus> getTermini(){
        List<Terminus> thisList = new ArrayList<>();
        terminusRepository.findAll().forEach(thisList::add);
        return thisList;
    }

    public void updateTerminus(String id,Terminus terminus){
        terminusRepository.save(terminus);
    }

}
