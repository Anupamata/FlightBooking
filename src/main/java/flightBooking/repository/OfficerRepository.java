package flightBooking.repository;

import flightBooking.model.Address;
import flightBooking.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer,Long> {
}
