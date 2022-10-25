package flightBooking.model;
import javax.persistence.*;

@Entity
@Table(name="bookedtickets")
public class BookedTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private long bookingId;
    @Column(name = "passengerId")
    private String passengerId;
    @Column(name = "flightId")
    private double flightId;
    @Column(name = "seatsReserved")
    private long seatsReserved;


    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public double getFlightId() {
        return flightId;
    }

    public void setFlightId(double flightId) {
        this.flightId = flightId;
    }

    public long getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(long seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}