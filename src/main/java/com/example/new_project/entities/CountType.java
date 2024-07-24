package com.example.new_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class CountType {
    @Id
    private Integer year;
    private Long  count;
    private Integer month;

    public CountType() {

    }
}
