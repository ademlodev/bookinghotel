package com.ademlo.bookinghotel.features.booking.infra.rest.DTO;

import java.util.Date;

public class BookingDTO {
    private final int employeeId;
    private final int roomId;
    private final Date startDate;
    private final Date endDate;

    public BookingDTO(int employeeId, int roomId, Date startDate, Date endDate) {
        this.employeeId = employeeId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
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
