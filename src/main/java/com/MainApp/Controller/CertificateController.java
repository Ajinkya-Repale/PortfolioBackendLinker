package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Certificate;
import com.MainApp.Service.CertificateService;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping("/all")
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @PostMapping("/admin/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return certificateService.addCertificate(certificate);
    }

    @PutMapping("/admin/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Certificate updateCertificate(@PathVariable String id, @RequestBody Certificate certificate) {
        return certificateService.updateCertificate(id, certificate);
    }

    @DeleteMapping("/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCertificate(@PathVariable String id) {
        certificateService.deleteCertificate(id);
    }
}