package flightBooking.dao;

import flightBooking.model.BookedTickets;
import flightBooking.model.FlightDetails;

import java.util.List;
import java.util.Optional;

public interface FlightDetailsDao {
    List<FlightDetails> fetchAllPersons();
    Optional<FlightDetails> getPersonById(long id);
    void insertPerson(FlightDetails flightDetails);
}
