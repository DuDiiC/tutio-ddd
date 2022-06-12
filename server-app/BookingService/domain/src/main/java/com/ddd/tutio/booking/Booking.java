package com.ddd.tutio.booking;

import com.ddd.tutio.base.AggregateRoot;
import com.ddd.tutio.base.DomainEvent;
import com.ddd.tutio.booking.event.BookingCancelled;
import com.ddd.tutio.booking.event.BookingPlanned;
import com.ddd.tutio.booking.event.PlanBookingRequested;
import com.ddd.tutio.course.CourseId;
import com.ddd.tutio.pupil.PupilId;

import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Agregat rezerwacji. Zamówienie lekcji przez ucznia w ramach wybranego kursu z odpowiednim wyprzedzeniem czasowym. Rezerwacja i po dokonaniu opłaty
 * prowadzi do utworzenia spotkania.
 */
public class Booking implements AggregateRoot<BookingId> {

    private List<DomainEvent> events = new ArrayList<>();

    /**
     * Identyfikator rezerwacji.
     */
    private BookingId bookingId;

    /**
     * Identyfikator kursu związanego z rezerwacją.
     */
    private CourseId courseId;

    /**
     * Indentyfikator ucznia dokonującego rezerwacji.
     */
    private PupilId pupilId;

    /**
     * Czas trwania spotkania tworzonego na podstawie rezerwacji.
     */
    private MeetingDuration meetingDuration;

    /**
     * Cena lekcji w ramach rezerwacji.
     */
    private LessonPrice lessonPrice;

    /**
     * Aktualny status rezerwacji.
     */
    private BookingStatus status;

    protected Booking() {
    }

    Booking(BookingTemplate template, PlanBookingRequested event) {
        this.bookingId = template.getIdentifier();
        this.courseId = template.courseId;
        this.pupilId = template.pupilId;
        this.meetingDuration = new MeetingDuration(event.startTime, event.endTime);
        this.lessonPrice = template.lessonPrice;
        this.status = BookingStatus.PLANNED;

        events.add(new BookingPlanned(UUID.randomUUID(), Instant.now(), template.getIdentifier()));
    }

    @Override
    public BookingId getIdentifier() {
        return this.bookingId;
    }

    @Override
    public List<DomainEvent> events() {
        return Collections.unmodifiableList(this.events);
    }

    /**
     * @return aktualny status rezerwacji
     */
    public BookingStatus status() {
        return status;
    }

    /**
     * Wylicza podstawowy koszt spotkania, na podstawie czasu trwania spotkania (zaokrąglonego do pełnych minut) i ceny lekcji.
     * Wynik zaokrąglany jest do drugiego miejsca po przecinku (pełnych groszy).
     *
     * @return podstawowy koszt spotkania
     */
    public MeetingCost calculateBaseMeetingCost() {
        var calculatedCost = this.lessonPrice.price
                .multiply(this.meetingDuration.partOfHour())
                .setScale(2, RoundingMode.HALF_UP);
        return new MeetingCost(calculatedCost, this.lessonPrice.currency);
    }

    /**
     * Zatwierdza rezerwację.
     */
    public void approve() {
        if (this.status.canBeApproved()) {
            this.status = BookingStatus.APPROVED;
            events.add(new BookingPlanned(UUID.randomUUID(), Instant.now(), this.bookingId));
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Anuluje rezerwację.
     * @param reason powód anulowania rezerwacji
     */
    public void cancel(String reason) {
        if (this.status.canBeCancelled()) {
            this.status = BookingStatus.CANCELED;
            events.add(new BookingCancelled(UUID.randomUUID(), Instant.now(), this.bookingId, reason));
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Akceptuje rezerwację, co prowadzi do utworzenia nowego planowanego spotkania.
     * <br>
     * <b>!funkcjonalność niezaimplementowana!</b>
     */
    public void accept() {
        if (this.status.canBeAccepted()) {
            this.status = BookingStatus.ACCEPTED;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
