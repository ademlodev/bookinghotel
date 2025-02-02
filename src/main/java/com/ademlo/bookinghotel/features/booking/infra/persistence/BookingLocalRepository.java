package com.ademlo.bookinghotel.features.booking.infra.persistence;

import com.ademlo.bookinghotel.features.booking.domain.model.Booking;
import com.ademlo.bookinghotel.features.booking.infra.rest.DTO.BookingDTO;
import com.ademlo.bookinghotel.features.booking.infra.rest.DTO.BookingResponse;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class BookingLocalRepository {
    private final Map<String, Booking> bookings;

    public BookingLocalRepository() {
        this.bookings = new HashMap<>();
    }

    public String addBooking(Booking booking){
        bookings.put(booking.getId(),booking);
        return booking.getId();
    }

    public Booking getBookingBy(String id){
        return this.bookings.get(id);
    }
}
