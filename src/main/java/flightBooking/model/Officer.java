package flightBooking.model;

import javax.persistence.*;

@Entity
@Table(name="officer")
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "officerId")
    private long officerId;
    @Column(name = "officerName")
    private String officerName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(long officerId) {
        this.officerId = officerId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(long idAddress) {
        this.idAddress = idAddress;
    }

    @Column(name = "idAddress")
    private long idAddress;



}