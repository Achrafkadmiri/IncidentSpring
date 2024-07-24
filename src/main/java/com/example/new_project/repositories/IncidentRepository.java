package com.example.new_project.repositories;

import com.example.new_project.entities.CountIncident;
import com.example.new_project.entities.CountType;
import com.example.new_project.entities.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {
    @Query("SELECT i FROM Incident i where i.traited is false")
    public List<Incident> getAllIncidentNonTraited();
    @Query("SELECT i FROM Incident i where i.traited is true")
    public List<Incident> getAllIncidentTraited();
    @Query("SELECT new CountIncident(YEAR(i.date), count(*), MONTH(i.date) ) " +
            "FROM Incident i " +
            "WHERE i.traited = ?1 and YEAR(i.date)= ?2 "+
            "GROUP BY MONTH(i.date)"

            )
    public List<CountIncident> getCountPerYear(Boolean status,int year);
    @Query("SELECT new CountIncident(YEAR(i.dateTraited), count(*), MONTH(i.dateTraited) ) " +
            "FROM Incident i " +
            "WHERE i.traited = ?1 and YEAR(i.dateTraited)= ?2 "+
            "GROUP BY MONTH(i.dateTraited)"

    )
    public List<CountIncident> getCountTraited(Boolean status,int year);
    @Query("SELECT new CountType(YEAR(i.date), count(*), MONTH(i.date) ) " +
            "FROM Incident i " +
            "WHERE YEAR(i.date)= ?1 and i.errorCause LIKE CONCAT(?2, '%') "+
            "GROUP BY MONTH(i.date)"
    )
    public List<CountType> getByTypeError(int year, String erreur);


}
