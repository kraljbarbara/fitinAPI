package si.tpo.fitin.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class User {
    private Integer id;
    private String username;
    private String email;
    private String name;
    private Boolean vip;
    private String bankAccount;
    private BigDecimal startingWeight;
    private BigDecimal goalWeight;
    private BigDecimal currentWeight;
    private String equipment1;
    private String equipment2;
    private String equipment3;
    private String equipment4;
    private String equipment5;
    private String equipment6;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "vip", nullable = false, columnDefinition = "bit default 0")
    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    @Basic
    @Column(name = "bank_account", nullable = true, length = 45)
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Basic
    @Column(name = "starting_weight", nullable = true, precision = 2)
    public BigDecimal getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(BigDecimal startingWeight) {
        this.startingWeight = startingWeight;
    }

    @Basic
    @Column(name = "goal_weight", nullable = true, precision = 2)
    public BigDecimal getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(BigDecimal goalWeight) {
        this.goalWeight = goalWeight;
    }

    @Basic
    @Column(name = "current_weight", nullable = true, precision = 2)
    public BigDecimal getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(BigDecimal currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Basic
    @Column(name = "equipment1", nullable = true, length = 45)
    public String getEquipment1() {
        return equipment1;
    }

    public void setEquipment1(String equipment1) {
        this.equipment1 = equipment1;
    }

    @Basic
    @Column(name = "equipment2", nullable = true, length = 45)
    public String getEquipment2() {
        return equipment2;
    }

    public void setEquipment2(String equipment2) {
        this.equipment2 = equipment2;
    }

    @Basic
    @Column(name = "equipment3", nullable = true, length = 45)
    public String getEquipment3() {
        return equipment3;
    }

    public void setEquipment3(String equipment3) {
        this.equipment3 = equipment3;
    }

    @Basic
    @Column(name = "equipment4", nullable = true, length = 45)
    public String getEquipment4() {
        return equipment4;
    }

    public void setEquipment4(String equipment4) {
        this.equipment4 = equipment4;
    }

    @Basic
    @Column(name = "equipment5", nullable = true, length = 45)
    public String getEquipment5() {
        return equipment5;
    }

    public void setEquipment5(String equipment5) {
        this.equipment5 = equipment5;
    }

    @Basic
    @Column(name = "equipment6", nullable = true, length = 45)
    public String getEquipment6() {
        return equipment6;
    }

    public void setEquipment6(String equipment6) {
        this.equipment6 = equipment6;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(vip, user.vip) &&
                Objects.equals(bankAccount, user.bankAccount) &&
                Objects.equals(startingWeight, user.startingWeight) &&
                Objects.equals(goalWeight, user.goalWeight) &&
                Objects.equals(currentWeight, user.currentWeight) &&
                Objects.equals(equipment1, user.equipment1) &&
                Objects.equals(equipment2, user.equipment2) &&
                Objects.equals(equipment3, user.equipment3) &&
                Objects.equals(equipment4, user.equipment4) &&
                Objects.equals(equipment5, user.equipment5) &&
                Objects.equals(equipment6, user.equipment6) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, name, vip, bankAccount, startingWeight, goalWeight, currentWeight, equipment1, equipment2, equipment3, equipment4, equipment5, equipment6, password);
    }
}
