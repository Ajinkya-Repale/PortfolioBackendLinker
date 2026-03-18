package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.About;
import com.MainApp.Repository.AboutRepository;

@Service
public class AboutService {
	
	 @Autowired
	    private AboutRepository aboutRepository;
	 
	    // ── PUBLIC ────────────────────────────────────────────
	 
	    /** Anyone can fetch the about info */
	    public List<About> getAll() {
	        return aboutRepository.findAll();
	    }
	 
	    public Optional<About> getById(String id) {
	        return aboutRepository.findById(id);
	    }
	 
	    // ── ADMIN ONLY ────────────────────────────────────────
	 
	    /** Create a new about entry */
	    public About create(About about) {
	        return aboutRepository.save(about);
	    }
	 
	    /** Update existing about entry by id */
	    public About update(String id, About updated) {
	        return aboutRepository.findById(id).map(existing -> {
	            existing.setName(updated.getName());
	            existing.setRole(updated.getRole());
	            existing.setBio1(updated.getBio1());
	            existing.setBio2(updated.getBio2());
	            existing.setLocation(updated.getLocation());
	            existing.setCollege(updated.getCollege());
	            existing.setDegree(updated.getDegree());
	            return aboutRepository.save(existing);
	        }).orElseThrow(() -> new RuntimeException("About entry not found with id: " + id));
	    }
	 
	    /** Delete about entry by id */
	    public void delete(String id) {
	        aboutRepository.deleteById(id);
	    }
}
