package flightBooking.service;

import flightBooking.model.FlightDetails;

import java.util.List;

public interface FlightDetailsService {
    List<FlightDetails> fetchAllFlightDetails();
    FlightDetails getFlightById(long personId);
    FlightDetails insertFlight(FlightDetails flightDetails);
    List<FlightDetails> fetchAllAvailableFlight();
}
