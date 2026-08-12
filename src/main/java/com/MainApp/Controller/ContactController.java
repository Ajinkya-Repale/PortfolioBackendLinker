package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Contact;
import com.MainApp.Entity.ContactMessage;
import com.MainApp.Service.ContactService;
import com.MainApp.Service.ContactMessageService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("http://localhost:5173")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactMessageService contactMessageService;

    // Public API (portfolio visitors can view)
    @GetMapping("/view")
    public List<Contact> getContactDetails() {
        return contactService.getContact();
    }

    // Admin add contact section
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    // Admin edit contact section
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Contact updateContact(@PathVariable String id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    // Public - visitor submits contact form
    @PostMapping("/submit")
    public ContactMessage submitContactForm(@RequestBody ContactMessage msg) {
        return contactMessageService.save(msg);
    }

    // Admin - view all submitted messages
    @GetMapping("/messages")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ContactMessage> getAllMessages() {
        return contactMessageService.getAll();
    }

}