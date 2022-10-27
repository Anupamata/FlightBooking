package flightBooking.service;

import flightBooking.model.BookedTickets;

import java.util.List;

public interface BookingService {
    List<BookedTickets> fetchAllBooking();
    BookedTickets getBookingById(long personId);
    BookedTickets insertBookingDetails(BookedTickets bookedTickets);
    List<BookedTickets> getBookingByPassengerId(long id);
    List<BookedTickets> getBookingByFlightId(long id);
    void deleteById(long id);
}
