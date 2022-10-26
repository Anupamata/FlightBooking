package flightBooking.repository;

import flightBooking.model.Address;
import flightBooking.model.FlightDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails,Long> {
    @Query("select flights from FlightDetails flights where flights.seats>0")
    List<FlightDetails> fetchAllAvailableFlight();
}
