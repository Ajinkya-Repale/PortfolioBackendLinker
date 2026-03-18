package com.MainApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Experience;
import com.MainApp.Repository.ExperienceRepository;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository exRepo;

    // Get all experience records
    public List<Experience> getAllExperience() {
        return exRepo.findAll();
    }

    // Add new experience
    public Experience addExperience(Experience experience) {
        return exRepo.save(experience);
    }

    // Update experience
    public Experience updateExperience(String id, Experience experience) {
        experience.setId(id);
        return exRepo.save(experience);
    }

    // Delete experience
    public void deleteExperience(String id) {
        exRepo.deleteById(id);
    }
}