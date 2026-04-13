package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Education;
import com.MainApp.Repository.EducationRepository;

@Service
public class EducationService {

    @Autowired
    EducationRepository eduRepo;

    // Get all education records
    public List<Education> getAllEducation() {
        return eduRepo.findAll();
    }

    // Add new education
    public Education addEducation(Education education) {
        return eduRepo.save(education);
    }

    // Update education
    public Education updateEducation(String id, Education education) {

        Optional<Education> existingEdu = eduRepo.findById(id);

        if (existingEdu.isPresent()) {
            Education edu = existingEdu.get();

            edu.setCollegeTitle(education.getCollegeTitle());
            edu.setStartYear(education.getStartYear());
            edu.setEndYear(education.getEndYear());
            edu.setPercentage(education.getPercentage());
            edu.setDegree(education.getDegree());

            return eduRepo.save(edu);
        } else {
            throw new RuntimeException("Education record not found with id: " + id);
        }
    }

    // Delete education
    public void deleteEducation(String id) {
        eduRepo.deleteById(id);
    }
}