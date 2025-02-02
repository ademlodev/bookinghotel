package com.ademlo.bookinghotel.features.booking.infra.rest.DTO;

public class BookingResponse {
    private final int bookingId;
    private final String message;

    public BookingResponse(int bookingId, String message) {
        this.bookingId = bookingId;
        this.message = message;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getMessage() {
        return message;
    }
}
