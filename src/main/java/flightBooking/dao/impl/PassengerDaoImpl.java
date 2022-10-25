package flightBooking.dao.impl;

import flightBooking.dao.PassengerDao;
import flightBooking.model.Passenger;
import flightBooking.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class PassengerDaoImpl implements PassengerDao {
    @Autowired
    PassengerRepository passengerRepository;
    @Transactional
    public List<Passenger> fetchAllPersons() {
        return passengerRepository.findAll();
    }
    @Transactional
    public Passenger login(String username, String password) {
        return passengerRepository.login(username,password);
    }
    @Transactional
    public Optional<Passenger> getPersonById(long id) {
        return passengerRepository.findById(id);

    }
    @Transactional
    public void  insertPerson(Passenger passenger) {
        passengerRepository.save(passenger);
    }
}
