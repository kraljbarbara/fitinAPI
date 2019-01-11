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
@Table(name = "routine_has_user")
@NamedQueries({
    @NamedQuery(name = "RoutineHasUser.findAll", query = "SELECT r FROM RoutineHasUser r"),
    @NamedQuery(name = "RoutineHasUser.findById", query = "SELECT r FROM RoutineHasUser r WHERE r.id = :id")})
public class RoutineHasUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "routine_id", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne(optional = false)
    private Routine routineId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne(optional = false)
    private User userId;

    public RoutineHasUser() {
    }

    public RoutineHasUser(Integer id) {
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof RoutineHasUser)) {
            return false;
        }
        RoutineHasUser other = (RoutineHasUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.RoutineHasUser[ id=" + id + " ]";
    }
    
}
