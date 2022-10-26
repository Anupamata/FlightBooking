package flightBooking.service;

import flightBooking.model.BookedTickets;

import java.util.List;

public interface BookingService {
    List<BookedTickets> fetchAllPerson();
    BookedTickets getPersonById(long personId);
    BookedTickets insertPerson(BookedTickets bookedTickets);
    List<BookedTickets> getBookingByPassengerId(long id);
    void deleteById(long id);
}
