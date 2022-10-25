package flightBooking.repository;

import flightBooking.model.Address;
import flightBooking.model.BookedTickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedTicketsRepository extends JpaRepository<BookedTickets,Long> {
}
