package Service;
import Domain.Movie;
import Domain.ClientCard;
import Repository.MovieRepository;
import Repository.ClientCardRepository;
import java.util.List;

public class ClientCardService {


    private ClientCardRepository repository;

    public ClientCardService(ClientCardRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(int id, String name, String firstName, String cnp, String birthDate, String registrationDate) {
        ClientCard existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (firstName.isEmpty()) {
                firstName = existing.getFirstname();
            }
            if (cnp.isEmpty()) {
                cnp = existing.getCnp();
            }
            if (birthDate.isEmpty()) {
                birthDate = existing.getBirthDate();
            }
            if (registrationDate.isEmpty()) {
                registrationDate = existing.getRegistrationDate();
            }
        }
        ClientCard client = new ClientCard(id, name, firstName, cnp, birthDate, registrationDate);
        repository.upsert(client);
    }

    public void remove(int id) {
        repository.remove(id);
    }

    public List<ClientCard> getAll() {
        return repository.getAll();
    }

}
