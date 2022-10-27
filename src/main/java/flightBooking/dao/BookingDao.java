package flightBooking.dao;

import flightBooking.model.BookedTickets;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    List<BookedTickets> fetchAllBooking();
    Optional<BookedTickets> getBookingById(long id);
    void insertBooking(BookedTickets customer);
    List<BookedTickets> getBookingByPassengerId(long id);

    void deleteBookingById(long id);
    List<BookedTickets> getBookingByFlightId(long id);
}
