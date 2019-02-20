package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.PlaceOnRoute;
import com.bilchege.commuteazy.Services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(method = RequestMethod.POST,value = "/addplace")
    public void addPlace(@RequestBody PlaceOnRoute place){
        placeService.addPlace(place);
    }

    @RequestMapping("/getplaces")
    public List<PlaceOnRoute> getPlaces(){
        return placeService.getPlaces();
    }

    @RequestMapping("/getplace/{id}")
    public Optional<PlaceOnRoute> getPlace(@PathVariable String id){
        return placeService.getPlace(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateplace")
    public void updatePlace(String id,PlaceOnRoute place){
        placeService.updatePlace(id,place);
    }

}
