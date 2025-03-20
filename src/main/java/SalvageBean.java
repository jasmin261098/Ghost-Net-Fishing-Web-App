import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Named
@RequestScoped
public class SalvageBean {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private PersonBean personBean;
    @Inject
    private GhostNetBean ghostNetBean;

    private GhostNet selectedGhostNet;
    private String salvagerName;

    // Method to assign a salvager to a ghost net
    public String assignSalvage() {
        // Ensure both the selected ghost net and the person exist
        if (selectedGhostNet != null && personBean.getPerson() != null) {
            // Assign the salvager (Person) to the GhostNet
            selectedGhostNet.setSalvager(personBean.getPerson());
            // Update the ghost net in the database
            em.merge(selectedGhostNet);
        }
        // Redirect to the index page
        return "index?faces-redirect=true";
    }

    // Getters and Setters
    public GhostNet getSelectedGhostNet() {
        return selectedGhostNet;
    }

    public void setSelectedGhostNet(GhostNet selectedGhostNet) {
        this.selectedGhostNet = selectedGhostNet;
    }

    public String getSalvagerName() {
        return salvagerName;
    }

    public void setSalvagerName(String salvagerName) {
        this.salvagerName = salvagerName;
    }
}
