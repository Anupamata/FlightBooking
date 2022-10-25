package flightBooking.service;

import flightBooking.model.BookedTickets;
import flightBooking.model.Passenger;

import java.util.List;

public interface BookingService {
    List<BookedTickets> fetchAllPerson();
    BookedTickets getPersonById(long personId);
    BookedTickets insertPerson(BookedTickets bookedTickets);
    BookedTickets getBookingByPassengerId(long id);
}
