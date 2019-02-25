package com.bilchege.commuteazy.Controllers;

import com.bilchege.commuteazy.Entities.Terminus;
import com.bilchege.commuteazy.Services.TerminusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
public class TerminusController {

    @Autowired
    private TerminusService terminusService;

    @RequestMapping(method = RequestMethod.POST,value = "/addterminus")
    public void createTerminus(@RequestBody Terminus terminus){
        terminusService.addTerminus(terminus);
    }

    @RequestMapping("/getterminus/{id}")
    public Optional<Terminus> getTerminus(@PathVariable String id){
        return terminusService.getTerminus(id);
    }

    @RequestMapping("/gettermini")
    public HashSet<Terminus> getTermini(){
        return terminusService.getTermini();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updateterminus/{id}")
    public void updateTerminus(@PathVariable String id,@RequestBody Terminus terminus){
        terminusService.updateTerminus(id,terminus);
    }

}
