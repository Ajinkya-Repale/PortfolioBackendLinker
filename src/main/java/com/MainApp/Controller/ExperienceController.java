package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Experience;
import com.MainApp.Service.ExperienceService;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    // Get all experience (Public)
    @GetMapping("/all")
    public List<Experience> getAllExperience() {
        return experienceService.getAllExperience();
    }

    // Add experience (Admin)
    @PostMapping("/admin/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.addExperience(experience);
    }

    // Update experience (Admin)
    @PutMapping("/admin/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Experience updateExperience(@PathVariable String id, @RequestBody Experience experience) {
        return experienceService.updateExperience(id, experience);
    }

    // Delete experience (Admin)
    @DeleteMapping("/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteExperience(@PathVariable String id) {
        experienceService.deleteExperience(id);
    }
}