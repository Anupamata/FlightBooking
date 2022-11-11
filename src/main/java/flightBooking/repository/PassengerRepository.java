package flightBooking.repository;

import flightBooking.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
   /* @Query("select passenger from Passenger passenger where passenger.username=:username and passenger.password=:password")
    public Passenger login(@Param("username") String username, @Param("password") String password);*/

    Passenger findByUsername(String userName);
    @Query("select passenger from Passenger passenger where passenger.username=:username")
    Passenger getPassengerByUserName(@Param("username") String loggedInUserName );
}
