package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Skills;
import com.MainApp.Service.SkillsService;

@RestController
@RequestMapping("/skills")
@CrossOrigin("http://localhost:5173")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    // Public API (anyone can see skills)
    @GetMapping("/all")
    public List<Skills> getAllSkills() {
        return skillsService.getAllSkills();
    }

    // Admin adds a skill (only sends name & group; icon assigned automatically)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Skills addSkill(@RequestBody Skills skill) {
        // Clear the icon from request just in case
        skill.setIcon(null);
        return skillsService.addSkill(skill);
    }

    // Admin edit skill (name change can update icon automatically)
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Skills updateSkill(@PathVariable String id, @RequestBody Skills skill) {
        // Clear the icon from request so backend can assign automatically based on name
        skill.setIcon(null);
        return skillsService.updateSkill(id, skill);
    }

    // Admin delete skill
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteSkill(@PathVariable String id) {
        skillsService.deleteSkill(id);
        return "Skill deleted successfully!";
    }
}