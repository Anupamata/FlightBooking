package flightBooking.dao;

import flightBooking.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerDao {
    List<Passenger> fetchAllPersons();

    Passenger login(String username, String password);
    Optional<Passenger> getPersonById(long id);
    void insertPerson(Passenger passenger);
}
