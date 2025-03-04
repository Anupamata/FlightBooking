package flightBooking.dao.impl;

import flightBooking.dao.OfficerDao;
import flightBooking.model.Officer;
import flightBooking.model.Passenger;
import flightBooking.repository.OfficerRepository;
import flightBooking.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class OfficerDaoImpl implements OfficerDao {
    @Autowired
    OfficerRepository officerRepository;
    @Transactional
    public List<Officer> fetchAllOfficers() {
        return officerRepository.findAll();
    }

/*    public Officer login(String username, String password) {
        return officerRepository.login(username,password);
    }*/
    @Transactional
    public Optional<Officer> getOfficerById(long id) {
        return officerRepository.findById(id);

    }
    @Transactional
    public void insertOfficer(Officer officer) {
        officerRepository.save(officer);
    }
}
