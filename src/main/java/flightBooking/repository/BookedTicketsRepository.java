package flightBooking.repository;

import flightBooking.model.BookedTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookedTicketsRepository extends JpaRepository<BookedTickets,Long> {
    @Query("select bookedTicket from BookedTickets bookedTicket where bookedTicket.passengerId=:passengerId")
    List<BookedTickets> getBookingByPassengerId(@Param("passengerId")long id);
}
