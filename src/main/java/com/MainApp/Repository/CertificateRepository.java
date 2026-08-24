package com.MainApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.MainApp.Entity.Certificate;

public interface CertificateRepository extends MongoRepository<Certificate, String> {
}