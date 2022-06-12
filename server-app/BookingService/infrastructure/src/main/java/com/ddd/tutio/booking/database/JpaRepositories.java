package com.ddd.tutio.booking.database;

import com.ddd.tutio.booking.Booking;
import com.ddd.tutio.booking.BookingId;
import com.ddd.tutio.booking.BookingTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Springowe repozytorium rezerwacji.
 */
@Repository
interface JpaBookingRepository extends JpaRepository<Booking, BookingId> {

    @Query(
            value = "SELECT * FROM booking.bookings b WHERE b.booking_id = :id AND b.booking_status != 'TEMPLATE'",
            nativeQuery = true
    )
    Optional<Booking> findById(@Param("id") UUID id);
}

/**
 * Springowe repozytorium szablonu rezerwacji.
 */
@Repository
interface JpaBookingTemplateRepository extends JpaRepository<BookingTemplate, BookingId> {

    @Query(
            value = "SELECT * FROM booking.bookings b WHERE b.booking_id = :id AND b.booking_status = 'TEMPLATE'",
            nativeQuery = true
    )
    Optional<BookingTemplate> findById(@Param("id") UUID id);
}
