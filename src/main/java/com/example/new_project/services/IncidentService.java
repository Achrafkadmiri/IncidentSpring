package com.example.new_project.services;

import com.example.new_project.entities.CountIncident;
import com.example.new_project.entities.CountType;
import com.example.new_project.entities.Incident;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidentService {
    public Incident getById(Long id);
    public List<Incident> getAll();
    public List<Incident> getAllNonTraited();
    public List<Incident> getAllTraited();
    public Incident save(Incident incident);
    public Incident traited(Incident incident);
    public List<CountIncident> getCount(Boolean status , int year);
    public List<CountIncident> getCountTraited(Boolean status , int year);
    public List<CountType> getCountByType( int year,String error);

    public Incident update(Incident incident);
    public void delete(Long id);

}
