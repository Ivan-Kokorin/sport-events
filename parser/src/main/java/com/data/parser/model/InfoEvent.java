package com.data.parser.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoEvent {

    private long packetVersion;
    private int fromVersion;
    private int catalogTablesVersion;
    private int catalogSpecialTablesVersion;
    private int catalogEventViewVersion;
    private int sportKindsVersion;
    private int topCompetitionsVersion;
    private List<Sport> sports;
    private List<Event> events;
    private List<Announcement> announcements;

    @Override
    public String toString() {
        return "InfoEvent{" + "\n" +
                "packetVersion=" + packetVersion + "\n" +
                ", fromVersion=" + fromVersion + "\n" +
                ", catalogTablesVersion=" + catalogTablesVersion + "\n" +
                ", catalogSpecialTablesVersion=" + catalogSpecialTablesVersion + "\n" +
                ", catalogEventViewVersion=" + catalogEventViewVersion + "\n" +
                ", sportKindsVersion=" + sportKindsVersion + "\n" +
                ", topCompetitionsVersion=" + topCompetitionsVersion + "\n" +
                ", sports=" + sports + "\n" +
                ", events=" + events + "\n" +
                ", announcements=" + announcements + "\n" +
                '}';
    }
}