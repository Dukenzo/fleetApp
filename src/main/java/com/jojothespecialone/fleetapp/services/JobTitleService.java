package com.jojothespecialone.fleetapp.services;


import com.jojothespecialone.fleetapp.models.JobTitle;
import com.jojothespecialone.fleetapp.models.Location;
import com.jojothespecialone.fleetapp.repositories.JobTitleRepository;
import com.jojothespecialone.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    //Save new state
    public void save(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    //get by Id
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    public void delete(int id) {
        jobTitleRepository.deleteById(id);
    }

    public List<JobTitle> getJobTitle() {
        return jobTitleRepository.findAll();
    }
}
