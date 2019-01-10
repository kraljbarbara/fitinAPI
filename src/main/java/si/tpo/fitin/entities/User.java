package si.tpo.fitin.entities;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Barbara
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByVip", query = "SELECT u FROM User u WHERE u.vip = :vip"),
    @NamedQuery(name = "User.findByBankAccount", query = "SELECT u FROM User u WHERE u.bankAccount = :bankAccount"),
    @NamedQuery(name = "User.findByStartingWeight", query = "SELECT u FROM User u WHERE u.startingWeight = :startingWeight"),
    @NamedQuery(name = "User.findByGoalWeight", query = "SELECT u FROM User u WHERE u.goalWeight = :goalWeight"),
    @NamedQuery(name = "User.findByCurrentWeight", query = "SELECT u FROM User u WHERE u.currentWeight = :currentWeight"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "vip")
    private boolean vip;
    @Column(name = "bank_account")
    private String bankAccount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "starting_weight")
    private Float startingWeight;
    @Column(name = "goal_weight")
    private Float goalWeight;
    @Column(name = "current_weight")
    private Float currentWeight;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<RoutineHasUser> routineHasUserList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String email, String name, boolean vip, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.vip = vip;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Float getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(Float startingWeight) {
        this.startingWeight = startingWeight;
    }

    public Float getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(Float goalWeight) {
        this.goalWeight = goalWeight;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.User[ id=" + id + " ]";
    }
    
}
