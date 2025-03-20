import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class GhostNetBean {
    
    @PersistenceContext
    private EntityManager em;  // Inject the EntityManager
    
    private GhostNet ghostNet = new GhostNet();
    
    @Inject
    private PersonBean personBean;
    
    // Method to report new GhostNet
    public String reportGhostNet() {
        em.persist(ghostNet);
        return "index?faces-redirect=true"; // Redirect to index page
    }
    
    // Getter and setter for ghostNet
    public GhostNet getGhostNet() {
        return ghostNet;
    }

    public void setGhostNet(GhostNet ghostNet) {
        this.ghostNet = ghostNet;
    }

    // Method to retrieve all GhostNets
    public List<GhostNet> getAllGhostNets() {
        return em.createQuery("SELECT g FROM GhostNet g", GhostNet.class).getResultList();
    }
}
