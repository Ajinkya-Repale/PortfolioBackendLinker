package com.MainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.MainApp.Entity.Hero;
import com.MainApp.Service.HeroService;

@RestController
@RequestMapping("/hero")
@CrossOrigin("http://localhost:5173")
public class HeroController {

    @Autowired
    private HeroService heroService;

    // Public API (everyone can view hero section)
    @GetMapping("/all")
    public List<Hero> getAllHero() {
        return heroService.getAllHero();
    }

    // Admin add hero
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public Hero addHero(@RequestBody Hero hero) {
        return heroService.addHero(hero);
    }

    // Admin update hero
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Hero updateHero(@PathVariable String id, @RequestBody Hero hero) {
        return heroService.updateHero(id, hero);
    }

    // Admin delete hero
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteHero(@PathVariable String id) {
        heroService.deleteHero(id);
        return "Hero deleted successfully!";
    }
}