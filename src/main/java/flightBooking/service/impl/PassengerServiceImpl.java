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
        return passengerDao.fetchAllPersons();
    }

    @Override
    public Passenger login(String username, String password) {
        return passengerDao.login(username,password);
    }
    @Override
    public Passenger getPersonById(long personId)  {
        Optional<Passenger> optionalPersonModel=passengerDao.getPersonById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public Passenger insertPerson(Passenger customer) {
        passengerDao.insertPerson(customer);
        return customer;
    }
}
