package flightBooking.service.impl;

import flightBooking.dao.OfficerDao;
import flightBooking.dao.PassengerDao;
import flightBooking.model.Officer;
import flightBooking.model.Passenger;
import flightBooking.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfficerServiceImpl implements OfficerService {
    @Autowired
    OfficerDao officerDao;
    @Override
    public List<Officer> fetchAllPerson() {
        return officerDao.fetchAllPersons();
    }

    @Override
    public Officer login(String username, String password) {
        return officerDao.login(username,password);
    }
    @Override
    public Officer getPersonById(long personId)  {
        Optional<Officer> optionalPersonModel=officerDao.getPersonById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public Officer insertPerson(Officer officer) {
        officerDao.insertPerson(officer);
        return officer;
    }
}
