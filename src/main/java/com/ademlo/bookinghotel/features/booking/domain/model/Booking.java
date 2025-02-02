package com.ademlo.bookinghotel.features.booking.domain.model;

import java.util.Date;
import java.util.UUID;

public class Booking {
    private final String id;
    private final int employeeId;
    private final int roomId;
    private final Date startDate;
    private final Date endDate;

    private Booking(String id, int employeeId, int roomId, Date startDate, Date endDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Booking newBooking(int employeeId, int roomId, Date startDate, Date endDate) {
        return  new Booking(UUID.randomUUID().toString(), employeeId, roomId,startDate, endDate);
    }

    public String getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getRoomId() {
        return roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
