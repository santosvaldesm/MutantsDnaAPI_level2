package com.challenge.mutantsDnaAPI.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.challenge.mutantsDnaAPI.service.MutantsServices;
import com.challenge.mutantsDnaAPI.wrapper.DnaWrapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;

@SpringBootTest
public class MutantsDnaControllerTests {
    
    @InjectMocks 
    private MutantsDnaController aMutantsDnaController;

    
    @Spy
    private MutantsServices aMutantsServices;  

    @Test
    protected void testSaveDnaWhenDnaIsMutantThenReturnHttpStatusOK(){        
        //Arrange
        DnaWrapper aDnaWrapper = new DnaWrapper(); 
        String[] aDna = {"ACCF","ACCF","ACCF","ACCF"};        
        aDnaWrapper.setDna(aDna);
        Mockito.doReturn(true).when(aMutantsServices).isMutant(aDna);        
        //Act        
        ResponseEntity<?> result = aMutantsDnaController.saveDna(aDnaWrapper);
        //Assert
        verify(aMutantsServices, Mockito.times(1)).isMutant(aDna);        
        assertEquals(result,new ResponseEntity<>(HttpStatus.OK));
    }

    @Test
    protected void testSaveDnaWhenDnaIsHumanThenReturnHttpStatusFORBIDDEN(){        
        //Arrange
        DnaWrapper aDnaWrapper = new DnaWrapper(); 
        String[] aDna = {"ACCF","ACCF","ACCF","ACCF"};        
        aDnaWrapper.setDna(aDna);
        Mockito.doReturn(false).when(aMutantsServices).isMutant(aDna);        
        //Act        
        ResponseEntity<?> result = aMutantsDnaController.saveDna(aDnaWrapper);
        //Assert
        verify(aMutantsServices, Mockito.times(1)).isMutant(aDna);        
        assertEquals(result,new ResponseEntity<>(HttpStatus.FORBIDDEN));
    } 

}
