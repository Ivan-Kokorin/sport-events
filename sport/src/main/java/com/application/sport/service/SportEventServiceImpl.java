package com.application.sport.service;

import com.application.sport.model.SportEvent;
import com.application.sport.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportEventServiceImpl implements SportEventService {
    final String FOOTBALL = "Футбол";
    @Autowired
    SportEventRepository sportEventRepository;

    @Override
    public void save(SportEvent sportEvent) {
        sportEventRepository.save(sportEvent);
    }

    @Override
    public boolean isExist(Long id) {
        List<SportEvent> allSportEvent = getAllSportEvent();
        SportEvent sportEvent1 = allSportEvent.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        if (sportEvent1 != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<SportEvent> getAllSportEvent() {
        return sportEventRepository.findAll();
    }

    public List<SportEvent> getAllFootballEvents() {
        List<SportEvent> allSportEvent = getAllSportEvent();
        return allSportEvent.stream().filter(s -> s.getSportName().equals(FOOTBALL)).collect(Collectors.toList());
    }
}
