package flightBooking.dao;

import flightBooking.model.BookedTickets;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    List<BookedTickets> fetchAllPersons();
    Optional<BookedTickets> getPersonById(long id);
    void insertPerson(BookedTickets customer);
    List<BookedTickets> getBookingByPassengerId(long id);

    void deleteById(long id);
    List<BookedTickets> getBookingByFlightId(long id);
}
