package flightBooking.service;

import flightBooking.model.Address;

public interface AddressService {
    Address getAddressById(long personId);
    void insertNewAddress(Address address);
    void deleteById(long id);
}
