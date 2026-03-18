package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Projects;
import com.MainApp.Service.ProjectService;

@RestController
@RequestMapping("/projects")
@CrossOrigin("http://localhost:5173")
public class ProjectController {

    @Autowired
    private ProjectService pService;

    // Get all projects
    @GetMapping("/all")
    public List<Projects> getAllProjects() {
        return pService.getAllProjects();
    }

    // Add a new project (admin only)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Projects addProject(@RequestBody Projects project) {
        return pService.saveProject(project);
    }

    // Edit an existing project by ID (admin only)
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Projects editProject(@PathVariable String id, @RequestBody Projects project) {
        return pService.updateProject(id, project);
    }

    // Delete a project by ID (admin only)
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProject(@PathVariable String id) {
        pService.deleteProject(id);
        return "Project deleted successfully!";
    }
}