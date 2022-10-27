package flightBooking.service.impl;

import flightBooking.dao.FlightDetailsDao;
import flightBooking.model.FlightDetails;
import flightBooking.service.FlightDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FlightDetailsServiceImpl implements FlightDetailsService {
    @Autowired
    FlightDetailsDao flightDetailsDao;

    @Override
    public List<FlightDetails> fetchAllFlightDetails() {
        return flightDetailsDao.fetchAllFlight();
    }

    @Override
    public FlightDetails getFlightById(long personId) {
        Optional<FlightDetails> optionalPersonModel = flightDetailsDao.getFlightById(personId);
        return optionalPersonModel.orElse(null);
    }

    @Override
    public FlightDetails insertFlight(FlightDetails flightDetails) {
        flightDetailsDao.insertFlight(flightDetails);
        return flightDetails;
    }

    @Override
    public List<FlightDetails> fetchAllAvailableFlight() {
        return flightDetailsDao.fetchAllAvailableFlight();
    }
}
