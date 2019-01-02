package si.tpo.fitin.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Workout {
    private Integer id;
    private String name;
    private Time duration;
    private String location;
    private String equipment;
    private String category;
    private String motivationalMessage;
    private BigDecimal k;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 45)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "equipment", nullable = true, length = 45)
    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Basic
    @Column(name = "category", nullable = false, length = 45)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "motivational_message", nullable = false, length = 300)
    public String getMotivationalMessage() {
        return motivationalMessage;
    }

    public void setMotivationalMessage(String motivationalMessage) {
        this.motivationalMessage = motivationalMessage;
    }

    @Basic
    @Column(name = "k", nullable = false, precision = 3)
    public BigDecimal getK() {
        return k;
    }

    public void setK(BigDecimal k) {
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id) &&
                Objects.equals(name, workout.name) &&
                Objects.equals(duration, workout.duration) &&
                Objects.equals(location, workout.location) &&
                Objects.equals(equipment, workout.equipment) &&
                Objects.equals(category, workout.category) &&
                Objects.equals(motivationalMessage, workout.motivationalMessage) &&
                Objects.equals(k, workout.k);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, location, equipment, category, motivationalMessage, k);
    }
}
