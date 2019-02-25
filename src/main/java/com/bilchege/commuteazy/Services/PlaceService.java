package com.bilchege.commuteazy.Services;

import com.bilchege.commuteazy.Entities.PlaceOnRoute;
import com.bilchege.commuteazy.Repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public void addPlace(PlaceOnRoute place){
        placeRepository.save(place);
    }

    public Optional<PlaceOnRoute> getPlace(String id){
        return placeRepository.findById(id);
    }

    public HashSet<PlaceOnRoute> getPlaces(){
        HashSet<PlaceOnRoute> thisList = new HashSet<>();
        placeRepository.findAll().forEach(thisList::add);
        return thisList;
    }

    public void updatePlace(String id,PlaceOnRoute place){
        placeRepository.save(place);
    }

}
