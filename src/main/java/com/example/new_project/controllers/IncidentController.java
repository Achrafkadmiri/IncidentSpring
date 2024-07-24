package com.example.new_project.controllers;

import com.example.new_project.entities.CountIncident;
import com.example.new_project.entities.CountType;
import com.example.new_project.entities.Incident;
import com.example.new_project.security.entities.Admin;
import com.example.new_project.security.services.AdminService;
import com.example.new_project.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class IncidentController {
    @Autowired
    IncidentService incidentService;
    @GetMapping("/findIncident")
    public Incident getIncident(@RequestParam("id") Long id){
        return incidentService.getById(id);
    }
    @GetMapping("/findAllIncident")
    public List<Incident> getAllIncident(){
        return incidentService.getAll();
    }
    @GetMapping("/findAllIncidentNonTraited")
    public List<Incident> getAllIncidentNonTraited(){
        return incidentService.getAllNonTraited();
    }
    @GetMapping("/findAllIncidentTraited")
    public List<Incident> getAllIncidentTraited(){
        return incidentService.getAllTraited();
    }

    @PostMapping("/saveIncident")
    public Incident addIncident(@RequestBody Incident incident){
        return incidentService.save(incident);
    }
    @GetMapping("/traited")
    public Incident traited(@RequestParam("id") Long id){
        Incident incident= getIncident(id);
        return incidentService.traited(incident);
    }
    @GetMapping("/getCount")
    public List<CountIncident> getCount(@RequestParam("status") Boolean status,@RequestParam("year") int year ){
        return incidentService.getCount(status,year);
    }
    @GetMapping("/getCountTraited")
    public List<CountIncident> getCountTraited(@RequestParam("status") Boolean status,@RequestParam("year") int year ){
        return incidentService.getCountTraited(status,year);
    }
    @GetMapping("/getCountError")
    public List<CountType> getCountTraited(@RequestParam("year") int year, @RequestParam("error") String error ){
        return incidentService.getCountByType(year,error);
    }
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;

//    @PostMapping("/RegisterAdmin")
//    public Admin AjouterAnnonce(@RequestBody Admin admin) {
//        return adminService.saveAdmin(admin);
//    }
    @PostMapping("/loginAdmin")
    public Admin login(@RequestBody Admin admin) {
        Admin c=adminService.findByUsername(admin.getUsername());
        System.out.println(c);
        System.out.println(admin);
        if (passwordEncoder.matches(admin.getPassword(),c.getPassword())){
            System.out.println("xqx");
            return adminService.findByUsername(admin.getUsername());
        }
        return null;
    }
}
