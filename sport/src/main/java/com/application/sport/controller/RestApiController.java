package com.application.sport.controller;

import com.application.sport.model.SportEvent;
import com.application.sport.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestApiController {
    @Autowired
    SportEventService sportEventService;

    @GetMapping(value = "/sports")
    public List<SportEvent> getAllSportEvent() {
        List<SportEvent> allSportEvent = sportEventService.getAllSportEvent();
        return allSportEvent.stream().sorted(Comparator.comparing(SportEvent::getSportName).reversed()).collect(Collectors.toList());
    }
}
