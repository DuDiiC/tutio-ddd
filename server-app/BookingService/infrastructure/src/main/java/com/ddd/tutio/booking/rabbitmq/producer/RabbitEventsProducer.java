package com.ddd.tutio.booking.rabbitmq.producer;

import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.port.event.producer.BookingEventsProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Producent zdarzeń domenowych w kontekście REZERWACJA dla RabbitMQ.
 */
@Component
public class RabbitEventsProducer implements BookingEventsProducer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitEventsProducer.class);

    private final String eventsExchange;
    private final RabbitTemplate template;

    public RabbitEventsProducer(@Value("${rabbitmq.exchange.events}") String eventsExchange, RabbitTemplate template) {
        this.eventsExchange = eventsExchange;
        this.template = template;
    }

    @Override
    public void publishEvent(DomainEvent event) {
        logger.info("Produce event: {}", event.getClass().getCanonicalName());
        template.convertAndSend(eventsExchange, event.getClass().getCanonicalName(), event);
    }
}
