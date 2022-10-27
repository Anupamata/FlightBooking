package flightBooking.dao;

import flightBooking.model.FlightDetails;

import java.util.List;
import java.util.Optional;

public interface FlightDetailsDao {
    List<FlightDetails> fetchAllFlight();
    Optional<FlightDetails> getFlightById(long id);
    void insertFlight(FlightDetails flightDetails);
    List<FlightDetails> fetchAllAvailableFlight();
}
