package com.ademlo.bookinghotel.features.booking.infra.rest;

import com.ademlo.bookinghotel.features.booking.infra.rest.DTO.BookingResponse;
import com.ademlo.bookinghotel.features.booking.infra.rest.DTO.BookingDTO;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @PostMapping("")
    public BookingResponse createBooking(@RequestBody BookingDTO bookingDTO){
        return new BookingResponse(1, "Reservation confirmed");
    }

    @GetMapping("/{bookingId}")
    public BookingDTO createBooking(@PathVariable String bookingId){
        return new BookingDTO(123, 101, Date.valueOf("2023-04-05"),Date.valueOf("2023-04-15"));
    }
}
