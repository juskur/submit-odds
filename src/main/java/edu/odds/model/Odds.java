package edu.odds.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Odds
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-18T10:06:35.423+02:00")

@Entity
public class Odds {

    @JsonIgnore
    private @Id
    @GeneratedValue
    Long id = null;

    @JsonProperty("betId")
    private Long betId = null;

    @JsonProperty("userId")
    private String userId = null;

    @JsonProperty("odds")
    private String odds = null;

    public Odds betId(Long betId) {
        this.betId = betId;
        return this;
    }

    /**
     * Get betId
     *
     * @return betId
     **/
    @ApiModelProperty(value = "")


    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Odds userId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * ID of user who is offering the odds
     *
     * @return userId
     **/
    @ApiModelProperty(value = "ID of user who is offering the odds")


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Odds odds(String odds) {
        this.odds = odds;
        return this;
    }

    /**
     * Get odds
     *
     * @return odds
     **/
    @ApiModelProperty(example = "1/10", value = "")


    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Odds odds = (Odds) o;
        return Objects.equals(this.betId, odds.betId) &&
                Objects.equals(this.userId, odds.userId) &&
                Objects.equals(this.odds, odds.odds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(betId, userId, odds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Odds {\n");

        sb.append("    betId: ").append(toIndentedString(betId)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    odds: ").append(toIndentedString(odds)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

