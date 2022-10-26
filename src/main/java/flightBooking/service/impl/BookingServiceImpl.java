package flightBooking.service.impl;

import flightBooking.dao.BookingDao;
import flightBooking.model.BookedTickets;
import flightBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookingServiceImpl  implements BookingService {

    @Autowired
    BookingDao bookingDao;

    @Override
    public List<BookedTickets> fetchAllPerson() {
        return bookingDao.fetchAllPersons();
    }

    @Override
    public BookedTickets getPersonById(long personId) {
        Optional<BookedTickets> optionalPersonModel = bookingDao.getPersonById(personId);
        return optionalPersonModel.orElse(null);
    }

    @Override
    public BookedTickets insertPerson(BookedTickets customer) {
        bookingDao.insertPerson(customer);
        return customer;
    }

    @Override
    public List<BookedTickets> getBookingByPassengerId(long id) {
        return bookingDao.getBookingByPassengerId(id);

    }

    @Override
    public void deleteById(long id) {
        bookingDao.deleteById(id);
    }
}