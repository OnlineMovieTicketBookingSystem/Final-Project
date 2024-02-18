package com.multiplex.services;

import java.util.List;

import com.multiplex.dtos.BookingDTO;
import com.multiplex.dtos.ShowCheckDTO;
import com.multiplex.models.Booking;

public interface BookingServiceInterface {

    void save(BookingDTO dto);

    List<Booking> listall();

    List<Booking> alluserbooking(int id);

    Booking findById(int id);

    List<Booking> allOccupiedBookings(ShowCheckDTO dto);

    void delete(int id);
}
