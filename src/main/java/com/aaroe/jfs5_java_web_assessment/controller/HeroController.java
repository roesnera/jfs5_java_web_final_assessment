package com.aaroe.jfs5_java_web_assessment.controller;

import com.aaroe.jfs5_java_web_assessment.model.Hero;
import com.aaroe.jfs5_java_web_assessment.model.HeroDTO;
import com.aaroe.jfs5_java_web_assessment.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/heroes")
@CrossOrigin
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping
    public List<Hero> getAllHeroes(){
        return heroService.getAllHeroes();
    }

    @PostMapping
    public void saveHero(@RequestBody HeroDTO hero){
        heroService.addHero(hero);
    }

    @PutMapping
    public void putHero(@RequestBody Hero hero){
        heroService.putHero(hero);
    }

    @PutMapping("/{id}")
    public void putHero(@RequestBody HeroDTO hero, @PathVariable Long id){
        heroService.putHero(hero, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        heroService.deleteHero(id);
    }
}
