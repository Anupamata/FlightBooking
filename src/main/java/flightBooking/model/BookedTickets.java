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
    private long passengerId;
    @Column(name = "flightId")
    private long flightId;
    @Column(name = "seatsReserved")
    private long seatsReserved;
    @Column(name = "boardingPoint")
    private String boardingPoint;
    @Column(name = "destination")
    private String  destination;
    @Column (name = "price")
    private long price;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    public String getBoardingPoint() {
        return boardingPoint;
    }

    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getSeatsReserved() {
        return seatsReserved;
    }

    public void setSeatsReserved(long seatsReserved) {
        this.seatsReserved = seatsReserved;
    }
}