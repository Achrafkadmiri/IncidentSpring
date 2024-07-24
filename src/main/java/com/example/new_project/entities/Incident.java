package com.example.new_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String Job;

    Date date;
    String directory;
    String file;
    String errorCause;
    Boolean traited;
    Date dateTraited;
}
