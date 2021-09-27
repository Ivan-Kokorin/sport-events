package com.application.sport.service;

import com.application.sport.model.SportEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SportEventService {
    public void save(SportEvent sportEvent);
    public boolean isExist(Long id);
    public List<SportEvent> getAllSportEvent();
    public List<SportEvent> getAllFootballEvents();
}
