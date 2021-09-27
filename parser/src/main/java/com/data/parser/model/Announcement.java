package com.data.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Announcement {
    private long id;
    private int segmentId;
    private int sportId;
    private String segmentName;
    private String sportName;
    private String team1;
    private String team2;

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", segmentName='" + segmentName + '\'' +
                ", sportName='" + sportName + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                '}' + "\n";
    }
}
