package com.data.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class MessageSender {
    @Autowired
    HandlerEventDataObject handlerEventDataObject;

    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //получение сырой информации и отправка обработанной информации в очередь RabbitMQ по расписанию
    @Scheduled(fixedDelay = 5000L)
    public void sendMessage() {
        final Message message = new Message((handlerEventDataObject.run()).getBytes(StandardCharsets.UTF_8));
        logger.info("Sending message...");
        rabbitTemplate.convertAndSend(RabbitConfiguration.QUEUE_MESSAGES, message);
    }
}
