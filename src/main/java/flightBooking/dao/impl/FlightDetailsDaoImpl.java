package flightBooking.dao.impl;

import flightBooking.dao.FlightDetailsDao;
import flightBooking.model.BookedTickets;
import flightBooking.model.FlightDetails;
import flightBooking.repository.BookedTicketsRepository;
import flightBooking.repository.FlightDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class FlightDetailsDaoImpl implements FlightDetailsDao {
    @Autowired
    FlightDetailsRepository flightDetailsRepository;
    @Transactional
    public List<FlightDetails> fetchAllFlight() {
        return flightDetailsRepository.findAll();
    }
    @Transactional
    public Optional<FlightDetails> getFlightById(long id) {
        return flightDetailsRepository.findById(id);

    }
    @Transactional
    public void insertFlight(FlightDetails flightDetails) {
        flightDetailsRepository.save(flightDetails);
    }

    @Override
    public List<FlightDetails> fetchAllAvailableFlight() {
        return flightDetailsRepository.fetchAllAvailableFlight();
    }
}
