package com.example.new_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class CountIncident {
    @Id
    private Integer year;
    private Long  count;
    private Integer month;

    public CountIncident() {

    }
}
