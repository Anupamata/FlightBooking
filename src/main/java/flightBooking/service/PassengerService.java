package flightBooking.service;

import flightBooking.model.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> fetchAllPerson();
    Passenger login(String username,String password);
    Passenger getPersonById(long personId);
    Passenger insertPerson(Passenger passenger);
}
