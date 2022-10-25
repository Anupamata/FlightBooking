package flightBooking.dao.impl;

import flightBooking.dao.AddressDao;
import flightBooking.model.Address;
import flightBooking.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class AddressDaoImpl implements AddressDao {
    @Autowired
    AddressRepository addressRepository;
    @Transactional
    public Optional<Address> getAddressById(long id) {
        return addressRepository.findById(id);

    }
    @Transactional
    public void insertNewAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void deleteById(long id) {
        addressRepository.deleteById(id);
    }
}
