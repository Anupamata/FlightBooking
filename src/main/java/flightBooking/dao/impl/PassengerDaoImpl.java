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
    public List<Passenger> fetchAllPassengers() {
        return passengerRepository.findAll();
    }
/*    @Transactional
    public Passenger login(String username, String password) {
        return passengerRepository.login(username,password);
    }*/
    @Transactional
    public Optional<Passenger> getPassengerById(long id) {
        return passengerRepository.findById(id);

    }
    @Transactional
    public void insertPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }
    public Passenger findByUserName(String userName) {

        Passenger user=passengerRepository.findByUsername(userName);
        return user;

    }

    @Override
    public Passenger getPassengerByUserName(String loggedInUserName) {
        return passengerRepository.getPassengerByUserName(loggedInUserName);
    }
}
