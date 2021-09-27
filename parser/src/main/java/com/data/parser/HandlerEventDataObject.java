package com.data.parser;

import com.data.parser.model.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandlerEventDataObject {
    @Autowired
    private Parser parser;

    public String run() {
        List<EntitySportEvent> sportEvents = new ArrayList<>();
        InfoEvent infoEvent = parser.parse();
        List<Sport> sports = infoEvent.getSports();
        List<Event> events = infoEvent.getEvents();
        for (Event event : events) {
            if (event.getTeam1() == null || event.getTeam2() == null) {
                continue;
            }
            Sport league = sports.stream().filter(s -> s.getId() == event.getSportId()).findFirst().orElse(null);
            Sport sport = null;
            if (league.getParentId() != 0) {
                int parentId = league.getParentId();
                sport = sports.stream().filter(s -> s.getId() == parentId).findFirst().orElse(null);
            }
            if (sport != null) {
                EntitySportEvent entitySportEvent = buildEntitySportEvent(event.getId(), sport.getName(), league.getName(), event.getTeam1(), event.getTeam2());
                sportEvents.add(entitySportEvent);
            }
        }
        List<Announcement> announcements = infoEvent.getAnnouncements();
        for (Announcement announcement : announcements) {
            EntitySportEvent entitySportEvent = buildEntitySportEvent(announcement.getId(), announcement.getSportName(), announcement.getSegmentName(), announcement.getTeam1(), announcement.getTeam2());
            sportEvents.add(entitySportEvent);
        }
        WrapEntitySportEvent wrapEntitySportEvent = new WrapEntitySportEvent();
        wrapEntitySportEvent.setSportEvents(sportEvents);
        Gson gson = new Gson();
        return gson.toJson(wrapEntitySportEvent);
    }

    private EntitySportEvent buildEntitySportEvent(long id, String sport, String segmentName, String team1, String team2) {
        String league = trimForLeagueName(sport, segmentName);
        String teams = concatenationTeamName(team1, team2);
        return new EntitySportEvent(id, sport, league, teams);
    }

    private String trimForLeagueName(String sport, String segmentName) {
        String league = segmentName.substring(sport.length() + 1);
        return league.trim();
    }

    private String concatenationTeamName(String teamName1, String teamName2) {
        return teamName1 + " - " + teamName2;
    }
}
