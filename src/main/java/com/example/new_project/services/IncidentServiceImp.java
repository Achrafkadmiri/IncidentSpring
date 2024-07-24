package com.example.new_project.services;

import com.example.new_project.entities.CountIncident;
import com.example.new_project.entities.CountType;
import com.example.new_project.entities.Incident;
import com.example.new_project.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncidentServiceImp implements IncidentService {
    @Autowired
    IncidentRepository incidentRepository;

    @Override
    public Incident getById(Long id) {
        return incidentRepository.findById(id).get();
    }

    @Override
    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }

    @Override
    public List<Incident> getAllNonTraited() {
        return incidentRepository.getAllIncidentNonTraited();
    }

    @Override
    public List<Incident> getAllTraited() {
        return incidentRepository.getAllIncidentTraited();
    }

    @Override
    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public Incident traited(Incident incident) {
        incident.setTraited(true);
        incident.setDateTraited(new Date());
        return incidentRepository.save(incident);
    }

    @Override
    public List<CountIncident> getCount(Boolean status, int year) {
        return incidentRepository.getCountPerYear(status, year);
    }

    @Override
    public List<CountIncident> getCountTraited(Boolean status, int year) {
        return incidentRepository.getCountTraited(status, year);
    }

    @Override
    public List<CountType> getCountByType(int year, String error) {
        return incidentRepository.getByTypeError(year, error);
    }

    @Override
    public Incident update(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public void delete(Long id) {
        incidentRepository.deleteById(id);
    }
}
