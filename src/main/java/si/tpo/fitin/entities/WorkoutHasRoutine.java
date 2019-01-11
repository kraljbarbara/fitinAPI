package si.tpo.fitin.entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Barbara
 */
@Entity
@Table(name = "workout_has_routine")
@NamedQueries({
    @NamedQuery(name = "WorkoutHasRoutine.findAll", query = "SELECT w FROM WorkoutHasRoutine w"),
    @NamedQuery(name = "WorkoutHasRoutine.findById", query = "SELECT w FROM WorkoutHasRoutine w WHERE w.id = :id")})
public class WorkoutHasRoutine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "routine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Routine routineId;
    @JoinColumn(name = "workout_id", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne(optional = false)
    private Workout workoutId;

    public WorkoutHasRoutine() {
    }

    public WorkoutHasRoutine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Routine getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Routine routineId) {
        this.routineId = routineId;
    }

    public Workout getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(Workout workoutId) {
        this.workoutId = workoutId;
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
        if (!(object instanceof WorkoutHasRoutine)) {
            return false;
        }
        WorkoutHasRoutine other = (WorkoutHasRoutine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.WorkoutHasRoutine[ id=" + id + " ]";
    }
    
}
