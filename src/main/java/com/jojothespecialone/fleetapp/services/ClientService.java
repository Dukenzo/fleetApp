package com.jojothespecialone.fleetapp.services;

import com.jojothespecialone.fleetapp.models.Client;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.repositories.ClientRepository;
import com.jojothespecialone.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired private ClientRepository clientRepository;
    @Autowired private CountryRepository countryRepository;

    public Object getClients;

    //Get Client by Id
    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }

    //Delete Client
    public void delete(int id){
        clientRepository.deleteById(id);
    }

    //Update Client
    public void save(Client client){
        clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }
}
