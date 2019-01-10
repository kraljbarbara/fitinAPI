package si.tpo.fitin.model;

import si.tpo.fitin.entities.Workout;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class workoutModel {

    private String name;
    private Time duration;
    private String location;
    private String category;
    private String motivationalMessage;
    private Float k;
    private String equipment;

    public workoutModel(String name, Time duration, String location, String category, String motivationalMessage, Float k, String name1) {
        this.name = name;
        this.duration = duration;
        this.location = location;
        this.category = category;
        this.motivationalMessage = motivationalMessage;
        this.k = k;
        this.equipment = name1;
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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
