package flightBooking.service.impl;

import flightBooking.dao.OfficerDao;
import flightBooking.model.Officer;
import flightBooking.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfficerServiceImpl implements OfficerService {
    @Autowired
    OfficerDao officerDao;
    @Override
    public List<Officer> fetchAllPerson() {
        return officerDao.fetchAllOfficers();
    }

/*    @Override
    public Officer login(String username, String password) {
        return officerDao.login(username,password);
    }*/
    @Override
    public Officer getOfficerById(long personId)  {
        Optional<Officer> optionalPersonModel=officerDao.getOfficerById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public Officer insertOfficer(Officer officer) {
        officerDao.insertOfficer(officer);
        return officer;
    }
}
