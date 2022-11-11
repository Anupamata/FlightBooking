package flightBooking.service;

import flightBooking.model.Passenger;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface PassengerService {
    List<Passenger> fetchAllPerson();
//    Passenger login(String username,String password);
    Passenger getPassengerById(long personId);
    Passenger insertPassenger(Passenger passenger);
    public Passenger findByUserName(String username);

    Passenger getPassengerByUserName(String loggedInUserName);
}
