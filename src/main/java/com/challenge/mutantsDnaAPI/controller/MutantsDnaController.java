package com.challenge.mutantsDnaAPI.controller;

import com.challenge.mutantsDnaAPI.service.MutantsServices;
import com.challenge.mutantsDnaAPI.wrapper.DnaWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class MutantsDnaController {    
    
    @Autowired
    MutantsServices mutantsServices;        
   
    @RequestMapping(value = "/mutant/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> saveDna(@RequestBody DnaWrapper aDnaWrapper) {        
        boolean isMutant = mutantsServices.isMutant(aDnaWrapper.getDna());        
        return isMutant ? new ResponseEntity<>(HttpStatus.OK) : 
                          new ResponseEntity<>(HttpStatus.FORBIDDEN);        
    }

}
