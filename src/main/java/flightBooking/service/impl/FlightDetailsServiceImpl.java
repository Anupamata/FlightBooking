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
    public List<FlightDetails> fetchAllPerson() {
        return flightDetailsDao.fetchAllPersons();
    }

    @Override
    public FlightDetails getPersonById(long personId) {
        Optional<FlightDetails> optionalPersonModel = flightDetailsDao.getPersonById(personId);
        return optionalPersonModel.orElse(null);
    }

    @Override
    public FlightDetails insertPerson(FlightDetails flightDetails) {
        flightDetailsDao.insertPerson(flightDetails);
        return flightDetails;
    }

    @Override
    public List<FlightDetails> fetchAllAvailableFlight() {
        return flightDetailsDao.fetchAllAvailableFlight();
    }
}
