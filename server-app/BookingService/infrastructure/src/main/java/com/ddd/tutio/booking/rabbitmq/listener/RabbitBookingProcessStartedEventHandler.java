package com.ddd.tutio.booking.rabbitmq.listener;

import com.ddd.tutio.booking.BookingTemplate;
import com.ddd.tutio.booking.BookingTemplateRepository;
import com.ddd.tutio.booking.event.BookingProcessStarted;
import com.ddd.tutio.booking.port.event.listener.BookingProcessStartedEventHandler;
import com.ddd.tutio.booking.port.event.producer.BookingEventsProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class RabbitBookingProcessStartedEventHandler implements BookingProcessStartedEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(RabbitBookingProcessStartedEventHandler.class);

    private final BookingTemplateRepository bookingTemplateRepository;
    private final BookingProcessStartedValidator validator;
    private final BookingEventsProducer eventsProducer;

    public RabbitBookingProcessStartedEventHandler(
            BookingTemplateRepository bookingTemplateRepository,
            BookingProcessStartedValidator validator, BookingEventsProducer eventsProducer
    ) {
        this.bookingTemplateRepository = bookingTemplateRepository;
        this.validator = validator;
        this.eventsProducer = eventsProducer;
    }

    @Override
    @Transactional
    @RabbitListener(queues = "${rabbitmq.queue.booking.booking-process-started}")
    public void handle(BookingProcessStarted event) {
        if (validator.validate(event)) {
            BookingTemplate bookingTemplate = new BookingTemplate(bookingTemplateRepository.generateNext(), event);
            bookingTemplateRepository.add(bookingTemplate);
            eventsProducer.publishEvents(bookingTemplate.events());
        } else {
            throw new IllegalArgumentException();
        }
        logger.info("Consume event: {}\n ID: {}", event.getClass().getCanonicalName(), event.eventId);
    }
}
