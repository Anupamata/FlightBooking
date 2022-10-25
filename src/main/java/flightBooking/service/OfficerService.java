package flightBooking.service;

import flightBooking.model.Officer;
import flightBooking.model.Passenger;

import java.util.List;

public interface OfficerService {
    List<Officer> fetchAllPerson();
    Officer login(String username,String password);
    Officer getPersonById(long personId);
    Officer insertPerson(Officer officer);
}
