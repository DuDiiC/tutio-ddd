package com.ddd.tutio.booking.rabbitmq.listener;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import comd.ddd.tutio.booking.port.event.listener.BookingProcessStartedEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitBookingProcessStartedEventHandler implements BookingProcessStartedEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(RabbitBookingProcessStartedEventHandler.class);

    private final ObjectMapper mapper;

    public RabbitBookingProcessStartedEventHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    @RabbitListener(queues = "${rabbitmq.queue.booking.booking-process-started}")
    public void handle(BookingProcessStarted event) {
        // TODO - implement
        logConsumption(event);
    }

    private void logConsumption(DomainEvent event) {
        try {
            String eventJson = mapper.writeValueAsString(event);
            logger.info("Consume event: {}\nEvent value: \n{}", event.getClass().getCanonicalName(), eventJson);
        } catch (JsonProcessingException e) {
            logger.warn(e.getMessage());
        }
    }
}
