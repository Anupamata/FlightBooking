package flightBooking.repository;

import flightBooking.model.Address;
import flightBooking.model.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails,Long> {
}
