package si.tpo.fitin.entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Barbara
 */
@Entity
@Table(name = "routine")
@NamedQueries({
    @NamedQuery(name = "Routine.findAll", query = "SELECT r FROM Routine r"),
    @NamedQuery(name = "Routine.findById", query = "SELECT r FROM Routine r WHERE r.id = :id"),
    @NamedQuery(name = "Routine.findByName", query = "SELECT r FROM Routine r WHERE r.name = :name"),
    @NamedQuery(name = "Routine.findByDuration", query = "SELECT r FROM Routine r WHERE r.duration = :duration"),
    @NamedQuery(name = "Routine.findByDescription", query = "SELECT r FROM Routine r WHERE r.description = :description"),
    @NamedQuery(name = "Routine.findByAuthor", query = "SELECT r FROM Routine r WHERE r.author = :author")})
public class Routine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "duration")
    @Temporal(TemporalType.TIME)
    private Date duration;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routineId")
    private List<WorkoutHasRoutine> workoutHasRoutineList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routineId")
    private List<RoutineHasUser> routineHasUserList;

    public Routine() {
    }

    public Routine(Integer id) {
        this.id = id;
    }

    public Routine(Integer id, String name, Date duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @XmlTransient
    public List<WorkoutHasRoutine> getWorkoutHasRoutineList() {
        return workoutHasRoutineList;
    }

    public void setWorkoutHasRoutineList(List<WorkoutHasRoutine> workoutHasRoutineList) {
        this.workoutHasRoutineList = workoutHasRoutineList;
    }

    @XmlTransient
    public List<RoutineHasUser> getRoutineHasUserList() {
        return routineHasUserList;
    }

    public void setRoutineHasUserList(List<RoutineHasUser> routineHasUserList) {
        this.routineHasUserList = routineHasUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routine)) {
            return false;
        }
        Routine other = (Routine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Routine[ id=" + id + " ]";
    }
    
}
