package flightBooking.dao.impl;

import flightBooking.dao.BookingDao;
import flightBooking.model.BookedTickets;
import flightBooking.repository.BookedTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class BookingDaoImpl implements BookingDao {
    @Autowired
    BookedTicketsRepository bookedTicketsRepository;
    @Transactional
    public List<BookedTickets> fetchAllPersons() {
        return bookedTicketsRepository.findAll();
    }
    @Transactional
    public Optional<BookedTickets> getPersonById(long id) {
        return bookedTicketsRepository.findById(id);

    }
    @Transactional
    public void  insertPerson(BookedTickets customer) {
        bookedTicketsRepository.save(customer);
    }

    @Override
    public BookedTickets getBookingByPassengerId(long id) {
        BookedTickets bookedTickets=bookedTicketsRepository.getBookingByPassengerId(id);
        return bookedTickets;
    }
}
