package flightBooking.dao;

import flightBooking.model.Address;

import java.util.Optional;

public interface AddressDao {
    Optional<Address> getAddressById(long id);
    void insertNewAddress(Address address);
    void deleteById(long id);
}
