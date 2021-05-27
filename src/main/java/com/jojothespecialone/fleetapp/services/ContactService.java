package com.jojothespecialone.fleetapp.services;

import com.jojothespecialone.fleetapp.models.Contact;
import com.jojothespecialone.fleetapp.models.Country;
import com.jojothespecialone.fleetapp.repositories.ContactRepository;
import com.jojothespecialone.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {


    @Autowired private ContactRepository contactRepository;
    

    //Get Contact by Id
    public Optional<Contact> findById(int id){
        return contactRepository.findById(id);
    }

    //Delete Contact
    public void delete(int id){
        contactRepository.deleteById(id);
    }

    //Update Contact
    public void save(Contact contact){
        contactRepository.save(contact);
    }

    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

}
