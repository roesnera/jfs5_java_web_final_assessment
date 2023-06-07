package com.aaroe.jfs5_java_web_assessment.service;

import com.aaroe.jfs5_java_web_assessment.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
//    Hero findByName(String name);
}
