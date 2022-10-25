package flightBooking.dao;

import flightBooking.model.Officer;
import flightBooking.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface OfficerDao {
    List<Officer> fetchAllPersons();

    Officer login(String username, String password);
    Optional<Officer> getPersonById(long id);
    void insertPerson(Officer officer);
}
