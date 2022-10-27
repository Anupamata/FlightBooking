package flightBooking.dao;

import flightBooking.model.Officer;

import java.util.List;
import java.util.Optional;

public interface OfficerDao {
    List<Officer> fetchAllOfficers();

    Officer login(String username, String password);
    Optional<Officer> getOfficerById(long id);
    void insertOfficer(Officer officer);
}
