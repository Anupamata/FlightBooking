package flightBooking.service;

import flightBooking.model.Officer;

import java.util.List;

public interface OfficerService {
    List<Officer> fetchAllPerson();
    Officer login(String username,String password);
    Officer getOfficerById(long personId);
    Officer insertOfficer(Officer officer);
}
