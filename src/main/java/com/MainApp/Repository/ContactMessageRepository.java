package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.MainApp.Entity.ContactMessage;

public interface ContactMessageRepository extends MongoRepository<ContactMessage, String> {
}