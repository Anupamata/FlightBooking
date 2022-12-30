package flightBooking.repository;

import flightBooking.model.Address;
import flightBooking.model.Officer;
import flightBooking.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OfficerRepository extends JpaRepository<Officer,Long> {
    /*@Query("select officer from Officer officer where officer.username=:username and officer.password=:password")
    public Officer login(@Param("username") String username, @Param("password") String password);*/
}
