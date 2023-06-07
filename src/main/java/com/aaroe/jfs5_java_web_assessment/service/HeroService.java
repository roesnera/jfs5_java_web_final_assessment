package com.aaroe.jfs5_java_web_assessment.service;

import com.aaroe.jfs5_java_web_assessment.model.Hero;
import com.aaroe.jfs5_java_web_assessment.model.HeroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {

    private final HeroRepository repository;


    public List<Hero> getAllHeroes(){
        return repository.findAll();
    }

    public void addHero(HeroDTO newHero){
        Hero heroToAdd = new Hero();

        heroToAdd.setPower(newHero.power());
        heroToAdd.setName(newHero.name());

        repository.save(heroToAdd);
    }

    public void deleteHero(Long id){
        repository.deleteById(id);
    }

    public void putHero(Hero putHero){
        Long id = putHero.getId();
        Hero foundHero = repository.findById(id).orElseThrow();
        foundHero.setName(putHero.getName());
        foundHero.setPower(putHero.getPower());
        repository.save(foundHero);
    }

    public void putHero(HeroDTO hero, Long id) {
        Hero foundHero = repository.findById(id).orElseThrow();
        foundHero.setName(hero.name());
        foundHero.setPower(hero.power());
        repository.save(foundHero);
    }
}
