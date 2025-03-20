import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String phone;
    
    @OneToMany(mappedBy = "salvager")
    private List<GhostNet> ghostNets;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<GhostNet> getGhostNets() {
        return ghostNets;
    }
    public void setGhostNets(List<GhostNet> ghostNets) {
        this.ghostNets = ghostNets;
    }
}
