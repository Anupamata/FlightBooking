package flightBooking.repository;

import flightBooking.model.Address;
import flightBooking.model.BookedTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookedTicketsRepository extends JpaRepository<BookedTickets,Long> {
    @Query("select bookedTicket from BookedTickets bookedTicket where bookedTicket.passengerId=:passengerId")
    BookedTickets getBookingByPassengerId(@Param("passengerId")long id);
}
