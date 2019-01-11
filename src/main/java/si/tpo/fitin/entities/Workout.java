package si.tpo.fitin.entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "workout")
@NamedQueries({
    @NamedQuery(name = "Workout.findAll", query = "SELECT w FROM Workout w"),
    @NamedQuery(name = "Workout.findById", query = "SELECT w FROM Workout w WHERE w.id = :id"),
    @NamedQuery(name = "Workout.findByName", query = "SELECT w FROM Workout w WHERE w.name = :name"),
    @NamedQuery(name = "Workout.findByDuration", query = "SELECT w FROM Workout w WHERE w.duration = :duration"),
    @NamedQuery(name = "Workout.findByLocation", query = "SELECT w FROM Workout w WHERE w.location = :location"),
    @NamedQuery(name = "Workout.findByCategory", query = "SELECT w FROM Workout w WHERE w.category = :category"),
    @NamedQuery(name = "Workout.findByMotivationalMessage", query = "SELECT w FROM Workout w WHERE w.motivationalMessage = :motivationalMessage"),
    @NamedQuery(name = "Workout.findByK", query = "SELECT w FROM Workout w WHERE w.k = :k")})
public class Workout implements Serializable {

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
    private Time duration;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @Column(name = "motivational_message")
    private String motivationalMessage;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "k")
    private Float k;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workoutId")
    private List<WorkoutHasRoutine> workoutHasRoutineList;
    @JoinColumn(name = "equipmentId", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne
    private Equipment equipmentId;

    public Workout() {
    }

    public Workout(Integer id) {
        this.id = id;
    }

    public Workout(Integer id, String name, Time duration, String location, String category, String motivationalMessage, Float k) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.location = location;
        this.category = category;
        this.motivationalMessage = motivationalMessage;
        this.k = k;
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

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMotivationalMessage() {
        return motivationalMessage;
    }

    public void setMotivationalMessage(String motivationalMessage) {
        this.motivationalMessage = motivationalMessage;
    }

    public Float getK() {
        return k;
    }

    public void setK(Float k) {
        this.k = k;
    }

    @XmlTransient
    public List<WorkoutHasRoutine> getWorkoutHasRoutineList() {
        return workoutHasRoutineList;
    }

    public void setWorkoutHasRoutineList(List<WorkoutHasRoutine> workoutHasRoutineList) {
        this.workoutHasRoutineList = workoutHasRoutineList;
    }

    public Equipment getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Equipment equipmentId) {
        this.equipmentId = equipmentId;
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
        if (!(object instanceof Workout)) {
            return false;
        }
        Workout other = (Workout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Workout[ id=" + id + " ]";
    }
    
}
