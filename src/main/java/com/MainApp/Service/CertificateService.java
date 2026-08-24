package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Certificate;
import com.MainApp.Repository.CertificateRepository;

@Service
public class CertificateService {

    @Autowired
    CertificateRepository certRepo;

    public List<Certificate> getAllCertificates() {
        return certRepo.findAll();
    }

    public Certificate addCertificate(Certificate certificate) {
        return certRepo.save(certificate);
    }

    public Certificate updateCertificate(String id, Certificate certificate) {
        Optional<Certificate> existingCert = certRepo.findById(id);
        if (existingCert.isPresent()) {
            Certificate cert = existingCert.get();
            cert.setTitle(certificate.getTitle());
            cert.setIssuer(certificate.getIssuer());
            cert.setIssueDate(certificate.getIssueDate());
            cert.setCredentialUrl(certificate.getCredentialUrl());
            return certRepo.save(cert);
        } else {
            throw new RuntimeException("Certificate record not found with id: " + id);
        }
    }

    public void deleteCertificate(String id) {
        certRepo.deleteById(id);
    }
}