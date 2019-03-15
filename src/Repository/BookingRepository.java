package Repository;
import Domain.ClientCard;
import Domain.ClientCardValidator;
import Domain.Booking;
import Domain.BookingValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookingRepository {

    private Map<Integer, Booking> storage = new HashMap<>();
    private BookingValidator validator;

    public BookingRepository(BookingValidator validator) {
        this.validator = validator;
    }

    public Booking findById(int id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a booking if it already exists.
     * @param booking the transaction to add or update.
     */
    public void upsert(Booking booking) {
        validator.validate(booking);
        storage.put(booking.getId(), booking);
    }

    /**
     * Removes a booking with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no transaction with the given id.
     */
    public void remove(int id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no transaction with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Booking> getAll() {
        return new ArrayList<>(storage.values());
    }
}
