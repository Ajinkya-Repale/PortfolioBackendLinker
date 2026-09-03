package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Footer;
import com.MainApp.Repository.FooterRepository;

@Service
public class FooterService {

    @Autowired
    private FooterRepository footerRepository;

    // ── PUBLIC ────────────────────────────────────────────

    /** Anyone can fetch the footer links */
    public List<Footer> getAll() {
        return footerRepository.findAll();
    }

    public Optional<Footer> getById(String id) {
        return footerRepository.findById(id);
    }

    // ── ADMIN ONLY ────────────────────────────────────────

    /** Create a new footer entry */
    public Footer create(Footer footer) {
        return footerRepository.save(footer);
    }

    /** Update existing footer entry by id */
    public Footer update(String id, Footer updated) {
        return footerRepository.findById(id).map(existing -> {
            existing.setLinkedinUrl(updated.getLinkedinUrl());
            existing.setGithubUrl(updated.getGithubUrl());
            existing.setEmail(updated.getEmail());
            return footerRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Footer entry not found with id: " + id));
    }

    /** Delete footer entry by id */
    public void delete(String id) {
        footerRepository.deleteById(id);
    }
}