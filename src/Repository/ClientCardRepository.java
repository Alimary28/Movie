package Repository;
import Domain.Movie;
import Domain.MovieValidator;
import Domain.ClientCard;
import Domain.ClientCardValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientCardRepository {

    private Map<Integer, ClientCard> storage = new HashMap<>();
    private ClientCardValidator validator;

    public ClientCardRepository(ClientCardValidator validator) {
        this.validator = validator;
    }

    public ClientCard findById(int id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a client if it already exists.
     * @param client the client to add or update.
     */
    public void upsert(ClientCard client) {
        validator.validate(client);
        storage.put(client.getId(), client);
    }

    /**
     * Removes a client with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no client with the given id.
     */
    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no client with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<ClientCard> getAll() {
        return new ArrayList<>(storage.values());
    }
}
