package com.ademlo.bookinghotel.features.booking.infra.rest;

import com.ademlo.bookinghotel.features.booking.domain.model.Booking;
import com.ademlo.bookinghotel.features.booking.infra.persistence.BookingLocalRepository;
import com.ademlo.bookinghotel.features.booking.infra.rest.DTO.BookingResponse;
import com.ademlo.bookinghotel.features.booking.infra.rest.DTO.BookingDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingLocalRepository bookingLocalRepository;

    public BookingController(BookingLocalRepository bookingLocalRepository) {
        this.bookingLocalRepository = bookingLocalRepository;
    }

    @PostMapping("")
    public BookingResponse createBooking(@RequestBody BookingDTO bookingDTO){
        String bookingId = bookingLocalRepository.addBooking(
                Booking.newBooking(bookingDTO.getEmployeeId(), bookingDTO.getRoomId(),bookingDTO.getStartDate(), bookingDTO.getEndDate()));
        return new BookingResponse(bookingId, "Reservation confirmed");
    }

    @GetMapping("/{bookingId}")
    public BookingDTO createBooking(@PathVariable String bookingId){
        Booking booking = bookingLocalRepository.getBookingBy(bookingId);
        return new BookingDTO(booking.getEmployeeId(), booking.getRoomId(), booking.getStartDate(),booking.getEndDate());
    }
}
