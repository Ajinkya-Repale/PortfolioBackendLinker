package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Projects;
import com.MainApp.Repository.ProjectRepo;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo pRepo;

    // Save a new project
    public Projects saveProject(Projects project) {
        return pRepo.save(project);
    }

    // Get all projects
    public List<Projects> getAllProjects() {
        return pRepo.findAll();
    }

    // Delete a project by ID
    public void deleteProject(String id) {
        pRepo.deleteById(id);
    }

    // Update an existing project
    public Projects updateProject(String id, Projects updateProject) {
        Optional<Projects> optionalProject = pRepo.findById(id);

        if (optionalProject.isPresent()) {
            Projects existingProject = optionalProject.get();

            existingProject.setTitle(updateProject.getTitle());
            existingProject.setDescription(updateProject.getDescription()); // fixed typo
            existingProject.setTech(updateProject.getTech());               // List<String> now
            existingProject.setLiveDemo(updateProject.getLiveDemo());
            existingProject.setGithub(updateProject.getGithub());
            existingProject.setImage(updateProject.getImage());

            return pRepo.save(existingProject);
        } else {
            throw new RuntimeException("Project with ID " + id + " not found");
        }
    }
}