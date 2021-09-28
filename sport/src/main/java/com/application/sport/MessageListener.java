package com.application.sport;

import com.application.sport.configuration.RabbitConfiguration;
import com.application.sport.model.SportEvent;
import com.application.sport.model.WrapSportObject;
import com.application.sport.service.SportEventService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
    @Autowired
    SportEventService sportEventService;

    //получение данных из очереди RabbitMQ, парсинг и сохранение новых событий в БД
    @RabbitListener(queues = RabbitConfiguration.QUEUE_MESSAGES)
    public void receiveMessage(final Message message) {
        logger.info("Received new message from parse-messages-queue");
        Gson gson = new Gson();
        WrapSportObject sportObject = gson.fromJson(new String(message.getBody()), WrapSportObject.class);
        List<SportEvent> sportEvents = sportObject.getSportEvents();
        for (SportEvent sportEvent : sportEvents) {
            if (!sportEventService.isExist(sportEvent.getId())) {
                sportEventService.save(sportEvent);
            }
        }
    }
}
