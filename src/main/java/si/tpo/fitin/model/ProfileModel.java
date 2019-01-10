package si.tpo.fitin.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ProfileModel {

    private Boolean vip;
    private String bankAccount;
    private Float currentWeight;
    private Float startingWeight;
    private Float goalWeight;

    @JsonCreator
    public ProfileModel(@JsonProperty("vip") Boolean vip,
                        @JsonProperty("bankAccount")String bankAccount,
                        @JsonProperty("currentWeight")Float currentWeight,
                        @JsonProperty("goalWeight") Float goalWeight,
                        @JsonProperty("startingWeight") Float startingWeight) {
        this.vip = vip;
        this.bankAccount = bankAccount;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.startingWeight = startingWeight;
    }

    public Boolean getvip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public String getbankAccount() {
        return bankAccount;
    }

    public void setbankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Float getcurrentWeight() {
        return currentWeight;
    }

    public void setcurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Float getstartingWeight() {
        return startingWeight;
    }

    public void setstartingWeight(Float startingWeight) {
        this.startingWeight = startingWeight;
    }

    public Float getgoalWeight() {
        return goalWeight;
    }

    public void setgoalWeight(Float goalWeight) {
        this.goalWeight = goalWeight;
    }

}
