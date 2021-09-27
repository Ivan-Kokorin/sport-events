package com.data.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
        private long id;
        private int sportId;
        private String team1;
        private String team2;

        @Override
        public String toString() {
                return "Event{" +
                        "id=" + id +
                        ", sportId=" + sportId +
                        ", team1='" + team1 + '\'' +
                        ", team2='" + team2 + '\'' +
                        '}' + "\n";
        }
}
