package flightBooking.service.impl;

import flightBooking.dao.PassengerDao;
import flightBooking.model.Passenger;
import flightBooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerDao passengerDao;
    @Override
    public List<Passenger> fetchAllPerson() {
        return passengerDao.fetchAllPassengers();
    }

  /*  @Override
        public Passenger login(String username, String password) {
            return passengerDao.login(username,password);
        }*/
    @Override
    public Passenger getPassengerById(long personId)  {
        Optional<Passenger> optionalPersonModel=passengerDao.getPassengerById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public Passenger insertPassenger(Passenger customer) {
        passengerDao.insertPassenger(customer);
        return customer;
    }

    @Override
    public Passenger findByUserName(String username) {
        return passengerDao.findByUserName(username);
    }

    @Override
    public Passenger getPassengerByUserName(String loggedInUserName) {
        return passengerDao.getPassengerByUserName(loggedInUserName);
    }

}
