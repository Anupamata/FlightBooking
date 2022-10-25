package flightBooking.service;

import flightBooking.model.FlightDetails;

import java.util.List;

public interface FlightDetailsService {
    List<FlightDetails> fetchAllPerson();
    FlightDetails getPersonById(long personId);
    FlightDetails insertPerson(FlightDetails flightDetails);
}
