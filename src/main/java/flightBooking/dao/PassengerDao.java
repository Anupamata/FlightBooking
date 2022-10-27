package flightBooking.dao;

import flightBooking.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerDao {
    List<Passenger> fetchAllPassengers();
    Passenger login(String username, String password);
    Optional<Passenger> getPassengerById(long id);
    void insertPassenger(Passenger passenger);
}
