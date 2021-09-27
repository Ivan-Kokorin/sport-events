package com.data.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntitySportEvent {
    private long id;
    private String sportName;
    private String league;
    private String teams;

    public EntitySportEvent() {
    }

    public EntitySportEvent(long id, String sportName, String league, String teams) {
        this.id = id;
        this.sportName = sportName;
        this.league = league;
        this.teams = teams;
    }

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
