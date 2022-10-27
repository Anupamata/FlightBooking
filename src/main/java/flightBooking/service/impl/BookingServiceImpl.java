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
    public List<BookedTickets> fetchAllBooking() {
        return bookingDao.fetchAllBooking();
    }

    @Override
    public BookedTickets getBookingById(long personId) {
        Optional<BookedTickets> optionalPersonModel = bookingDao.getBookingById(personId);
        return optionalPersonModel.orElse(null);
    }

    @Override
    public BookedTickets insertBookingDetails(BookedTickets customer) {
        bookingDao.insertBooking(customer);
        return customer;
    }

    @Override
    public List<BookedTickets> getBookingByPassengerId(long id) {
        return bookingDao.getBookingByPassengerId(id);

    }

    @Override
    public List<BookedTickets> getBookingByFlightId(long id) {
        return bookingDao.getBookingByFlightId(id);
    }

    @Override
    public void deleteById(long id) {
        bookingDao.deleteBookingById(id);
    }
}