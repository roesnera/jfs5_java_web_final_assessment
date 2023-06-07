package com.aaroe.jfs5_java_web_assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String power;
}
