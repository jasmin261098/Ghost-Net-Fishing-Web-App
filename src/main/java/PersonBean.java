import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Named
@RequestScoped
public class PersonBean {

    @PersistenceContext
    private EntityManager em;

    private Person person = new Person();

    // Method to save a new person (either a salvaging or reporting person)
    public String savePerson() {
        em.persist(person);
        return "index?faces-redirect=true"; // Redirect back to the index
    }

    // Getters and Setters for person and fields
    public Person getPerson() { 
    	return person;
    }
    public void setPerson(Person person) { 
    	this.person = person;
    }
}