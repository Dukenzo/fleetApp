package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.State;
import com.jojothespecialone.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public Object getStates;


    //Return list of states
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    //Save new state
    public void save(State state){
        stateRepository.save(state);
    }

    //get by Id
    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    public void delete(int id) {
        stateRepository.deleteById(id);
    }
}
