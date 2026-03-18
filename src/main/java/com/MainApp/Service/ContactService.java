package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Contact;
import com.MainApp.Repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepo;

    // Get contact details (for portfolio users)
    public List<Contact> getContact() {
        return contactRepo.findAll();
    }

    // Admin can add contact section
    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }

    // Admin update contact details
    public Contact updateContact(String id, Contact updatedContact) {

        Optional<Contact> optionalContact = contactRepo.findById(id);

        if(optionalContact.isPresent()) {

            Contact existingContact = optionalContact.get();

            existingContact.setHeader(updatedContact.getHeader());
            existingContact.setDescription(updatedContact.getDescription());
            existingContact.setEmail(updatedContact.getEmail());
            existingContact.setLocation(updatedContact.getLocation());
            existingContact.setAvailability(updatedContact.getAvailability());

            existingContact.setFormYourName(updatedContact.getFormYourName());
            existingContact.setFormYourEmail(updatedContact.getFormYourEmail());
            existingContact.setFormYourMessage(updatedContact.getFormYourMessage());

            existingContact.setGithubUrl(updatedContact.getGithubUrl());
            existingContact.setLinkedInUrl(updatedContact.getLinkedInUrl());
            existingContact.setEmailUrl(updatedContact.getEmailUrl());

            return contactRepo.save(existingContact);
        }

        else {
            throw new RuntimeException("Contact not found with id " + id);
        }
    }

}