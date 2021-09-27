package com.application.sport.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class SportEvent {
    @Id
    private long id;
    private String sportName;
    private String league;
    private String teams;

    @Override
    public String toString() {
        return "EntitySportEvent{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", league='" + league + '\'' +
                ", teams='" + teams + '\'' +
                '}' + "\n";
    }
}
