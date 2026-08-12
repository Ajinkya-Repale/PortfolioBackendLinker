package com.MainApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.ContactMessage;
import com.MainApp.Repository.ContactMessageRepository;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repo;

    public ContactMessage save(ContactMessage msg) {
        return repo.save(msg);
    }

    public List<ContactMessage> getAll() {
        return repo.findAll();
    }
}