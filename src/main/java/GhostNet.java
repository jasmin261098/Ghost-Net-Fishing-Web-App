import javax.persistence.*;
import java.io.Serializable;

@Entity
public class GhostNet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location; // GPS Coordinates
    private String size;
    private String status;

    @ManyToOne
    private Person salvager; // Salvaging person (only one person can be assigned)

    // Getter and Setter for salvager
    public Person getSalvager() {
        return salvager;
    }

    public void setSalvager(Person salvager) {
        this.salvager = salvager;
    }

    // Getter and Setter for other fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
