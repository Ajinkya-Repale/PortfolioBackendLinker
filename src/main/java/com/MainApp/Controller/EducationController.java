package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Education;
import com.MainApp.Service.EducationService;

@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    // Get all education records (Public)
    @GetMapping("/all")
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    // Add education (Admin)
    @PostMapping("/admin/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Education addEducation(@RequestBody Education education) {
        return educationService.addEducation(education);
    }

    // Update education (Admin)
    @PutMapping("/admin/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Education updateEducation(@PathVariable String id, @RequestBody Education education) {
        return educationService.updateEducation(id, education);
    }

    // Delete education (Admin)
    @DeleteMapping("/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEducation(@PathVariable String id) {
        educationService.deleteEducation(id);
    }
}