package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Hero;
import com.MainApp.Repository.HeroRepository;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepo;

    // Public: get hero data
    public List<Hero> getAllHero() {
        return heroRepo.findAll();
    }

    // Admin: add hero
    public Hero addHero(Hero hero) {
        return heroRepo.save(hero);
    }

    // Admin: delete hero
    public void deleteHero(String id) {
        heroRepo.deleteById(id);
    }

    // Admin: update hero
    public Hero updateHero(String id, Hero updatedHero) {

        Optional<Hero> optionalHero = heroRepo.findById(id);

        if(optionalHero.isPresent()) {

            Hero existingHero = optionalHero.get();

            existingHero.setIntroText(updatedHero.getIntroText());
            existingHero.setHeroTitle(updatedHero.getHeroTitle());
            existingHero.setHeroDescription(updatedHero.getHeroDescription());
            existingHero.setName(updatedHero.getName());
            existingHero.setRole(updatedHero.getRole());
            existingHero.setAvatarUrl(updatedHero.getAvatarUrl());

            return heroRepo.save(existingHero);
        }

        else {
            throw new RuntimeException("Hero not found with id " + id);
        }
    }
}